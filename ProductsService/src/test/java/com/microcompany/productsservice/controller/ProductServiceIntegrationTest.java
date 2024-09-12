package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.persistence.ProductsRepository;
import com.microcompany.productsservice.service.ProductsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// TODO: uncomment and implement methods
// @ExtendWith(SpringExtension.class)
public class ProductServiceIntegrationTest {

    // TODO: implement test configuration for generating ProductsService bean

    // TODO: implement setup for mock repo bean

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductServiceController controller;

    @MockBean
    private ProductsRepository productsRepository;

    @Test
    public void whenValidText_thenProductsShouldBeFound() {
    }

    @Test
    void givenProducts_whengetAllProducts_thenIsNotNull() {

    }

}