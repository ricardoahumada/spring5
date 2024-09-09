package com.example.demo.controllers;

import com.example.demo.models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping("/producto")
    public Product getOne() {
        return new Product(1L, "Escoba");
    }
}
