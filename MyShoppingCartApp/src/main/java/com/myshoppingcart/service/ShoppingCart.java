package com.myshoppingcart.service;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.persistence.CompraDBRepository;
import com.myshoppingcart.persistence.ICompraRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

//@Component
@Setter
public class ShoppingCart implements IShoppingCart {

    private ArrayList<Producto> items;
//    @Autowired
    private ICompraRepository repoCompras;

    public ShoppingCart() /*throws Exception*/ {
        items = new ArrayList<>();
//        repoCompras = new CompraDBRepository();
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
        for (Producto item : items) {
            System.out.println("prod:" + item);
            try {
                Compra compra = new Compra(null, 1, item.getMid(), 1, LocalDate.now());
                repoCompras.insertCompra(compra);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

}