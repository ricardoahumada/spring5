package com.microcompany.productsservice.exception;


public class GlobalProductException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GlobalProductException(String message) {
        super(message);
    }
}
