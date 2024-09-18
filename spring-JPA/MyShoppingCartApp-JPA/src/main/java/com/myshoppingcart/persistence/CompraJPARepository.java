package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;

@Setter
@Repository("CompraJPARepository")
public class CompraJPARepository implements ICompraRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Compra insertCompra(Compra nuevaCompra) throws Exception {

        // OBTENEMOS EL PRODUCTO
        Producto producto = em.find(Producto.class, nuevaCompra.getProducto().getPid());
        nuevaCompra.setProducto(producto);
        double precio = producto.getPrecio();
        int existencias = producto.getExistencias();

        // ACTUALIZAR EXISTENCIAS DE PRODUCTO
        producto.setExistencias(existencias - nuevaCompra.getCantidad());
        if (producto.getExistencias() < 0) {
            throw new Exception("Existencias insuficientes");
        }

        // OBTENER USUARIO  Y ACTUALIZAR SALDO
        Usuario usuario = em.find(Usuario.class, nuevaCompra.getUsuario().getUid());
        nuevaCompra.setUsuario(usuario);
        usuario.setSaldo(usuario.getSaldo() - precio * existencias);
        if (usuario.getSaldo() < 0) {
            throw new Exception("Saldo insuficientes");
        }

        // INSERTAR EN COMPRA
        em.persist(nuevaCompra);

        System.out.println("Nueva compra:" + nuevaCompra);

        return nuevaCompra;
    }
}
