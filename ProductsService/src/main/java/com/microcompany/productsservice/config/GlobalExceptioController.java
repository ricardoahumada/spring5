package com.microcompany.productsservice.config;

import com.microcompany.productsservice.exception.NewProductException;
import com.microcompany.productsservice.exception.ProductNotfoundException;
import com.microcompany.productsservice.model.StatusMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptioController {

    @ExceptionHandler(ProductNotfoundException.class)
    public ResponseEntity<StatusMessage> handleProductNotFoundException(ProductNotfoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StatusMessage(HttpStatus.NOT_FOUND.value(), "No encontrado"));
    }

    @ExceptionHandler(NewProductException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public StatusMessage handleNewProductException(NewProductException ex) {
        return new StatusMessage(HttpStatus.PRECONDITION_FAILED.value(), "Producto no correcto");
    }

}
