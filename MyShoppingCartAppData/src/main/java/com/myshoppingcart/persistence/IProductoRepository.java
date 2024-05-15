package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;

import java.util.List;

public interface IProductoRepository {
    public Producto getProduct(int id) throws Exception;
    public List<Producto> getProducts() throws Exception;
    public List<Producto> getUserProducts(int uid) throws Exception;
    public Producto insertarProducto(Producto prod) throws Exception;
    public Producto actualizarProducto(Producto prod) throws Exception;
    public boolean borrarProducto(Producto prod) throws Exception;

}
