package com.myshoppingcart.service;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Producto;

public interface IShoppingCart {
    double getBalance();

    void addItem(Producto item);

    void removeItem(Producto item)
            throws ProductNotFoundException;

    int getItemCount();

    void empty();

    void comprar();
}
