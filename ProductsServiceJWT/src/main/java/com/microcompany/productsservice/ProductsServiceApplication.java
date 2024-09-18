package com.microcompany.productsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(ProductsServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductsServiceApplication.class, args);
    }

}