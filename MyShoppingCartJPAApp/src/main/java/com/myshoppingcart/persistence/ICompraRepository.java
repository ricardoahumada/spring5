package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Compra;

public interface ICompraRepository {
    public Compra insertCompra(Compra nuevaCompra) throws Exception;

}
