package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

// TODO: uncomment and implement methods
@SpringBootTest
class ProductServiceControllerTest {

    @Autowired
    private ProductServiceController controller;

    @Test
    void givenProducts_whengetAllProducts_thenIsNotNull() {

    }

    @Test
    void givenProducts_whenVaildCreateProduct_thenIsCreatedAndHaveId() {


    }
}