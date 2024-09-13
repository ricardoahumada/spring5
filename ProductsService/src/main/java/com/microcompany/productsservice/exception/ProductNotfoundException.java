package com.microcompany.productsservice.exception;


public class ProductNotfoundException extends GlobalProductException {
    private static final long serialVersionUID = 3L;

    public ProductNotfoundException(String message) {
        super(message);
    }
}
