package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Component
@Setter
@Repository("ProductoJPARepository")
public class ProductoJPARepository implements IProductoRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public Producto getProduct(int id) throws Exception {
        return em.find(Producto.class, id);
    }

    @Override
    public List<Producto> getProducts() throws Exception {
        String sql = "SELECT p FROM Producto p";
        TypedQuery query = em.createQuery(sql, Producto.class);
        return query.getResultList();
    }

    @Override
    public List<Producto> getUserProducts(int uid) throws Exception {
        String sql = "SELECT p FROM Producto p INNER JOIN Compra c ON c.producto=p.pid WHERE c.usuario.id=?1";
        TypedQuery query = em.createQuery(sql, Producto.class);
        query.setParameter(1, uid);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Producto insertarProducto(Producto prod) throws Exception {
        em.persist(prod);
        return prod;
    }

    @Override
    @Transactional
    public Producto actualizarProducto(Producto prod) throws Exception {
        em.merge(prod);
        return prod;
    }

    @Override
    @Transactional
    public boolean borrarProducto(Producto prod) throws Exception {
        em.remove(em.contains(prod) ? prod : em.merge(prod));
        return true;
    }


}

