package com.myshoppingcart.service;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import com.myshoppingcart.persistence.ProductoRepository;
import com.myshoppingcart.persistence.UsuarioRepository;
import com.myshoppingcart.persistence.compra.CompraRepository;
import com.myshoppingcart.persistence.compra.ICompraRepository;
import com.myshoppingcart.persistence.IUsuarioRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Setter
@Service
public class ShoppingCart implements IShoppingCart {

    private ArrayList<Producto> items;

    @Autowired
    private CompraRepository repoCompras;
    @Autowired
    private ProductoRepository repoProductos;
    @Autowired
    private UsuarioRepository repoUsuarios;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    @Override
    public double getBalance() {
        double balance = 0.00;
        for (Iterator i = items.iterator(); i.hasNext(); ) {
            Producto item = (Producto) i.next();
            balance += item.getPrecio();
        }
        return balance;
    }

    @Override
    public void addItem(Producto item) {
        items.add(item);
    }

    @Override
    public void removeItem(Producto item)
            throws ProductNotFoundException {
        if (!items.remove(item)) {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void empty() {
        items.clear();
    }

    @Override
    public void comprar() {

        try {
            Usuario currentUser = repoUsuarios.findByEmailAndPassword("juana@e.com", "xxxx");
            Compra compra = new Compra(null, currentUser, items, LocalDate.now());
            repoCompras.insertCompra(compra);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void comprar_tx() {

        try {
            // obtenemos el usuario actual (simulado)
            Usuario currentUser = repoUsuarios.findByEmailAndPassword("juana@e.com", "xxxx");

            // obtenemos los productos
            List<Integer> productoIds = items.stream().map(aP -> aP.getPid()).collect(Collectors.toList());
            List<Producto> productos = repoProductos.findAllById(productoIds);

            // creamos y verificamos la compra
            Compra compra = new Compra(null, currentUser, productos, LocalDate.now());

            compra.isValid();

            // verificamos saldos y existencias
            if (currentUser.getSaldo() < compra.calcTotal()) {
                throw new RuntimeException("Saldo insuficiente en usuario");
            }

            for (Producto producto : productos) {
                if (producto.getExistencias() - 1 <= 0) {
                    throw new RuntimeException("Producto SIN existencias suficientes: " + producto);
                }
            }

            // actualizamos los sados y existencias
            currentUser.setSaldo(currentUser.getSaldo() - compra.calcTotal());
            for (Producto producto : productos) {
                producto.setExistencias(producto.getExistencias() - 1);
            }

            // persistimos
            repoCompras.save(compra);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}