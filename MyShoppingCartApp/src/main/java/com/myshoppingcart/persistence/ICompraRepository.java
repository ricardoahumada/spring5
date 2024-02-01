package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;

import java.util.List;

public interface ICompraRepository {
    public Compra insertCompra(Compra nuevaCompra) throws Exception;

}
