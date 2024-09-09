package com.example.demo.controllers;

import com.example.demo.models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @RequestMapping("/productos")
    public List<Product> getAll() {
        return List.of(
                new Product(1L, "Escoba"),
                new Product(2L, "Estropajo"),
                new Product(3L, "Pala"),
                new Product(4L, "Mopa")
        );

    }

    @RequestMapping("/productos/1")
    public Product getOne() {
        return new Product(1L, "Escoba");
    }


}
