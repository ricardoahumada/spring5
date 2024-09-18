package com.microcompany.productsservice.service;

import com.microcompany.productsservice.exception.NewProductException;
import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.persistence.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<Product> getProductsByText(String text) {
        return productsRepository.findByNameContaining(text);
    }

    public Product create(Product product) {
        try {
            product.isValid();
            return productsRepository.save(product);
        } catch (Exception e) {
            throw new NewProductException(e.getMessage());
        }
    }
}
