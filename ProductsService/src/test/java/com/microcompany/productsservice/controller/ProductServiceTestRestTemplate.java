package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

// TODO: uncomment and implement methods
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Sql("classpath:data_testing.sql")
public class ProductServiceTestRestTemplate {
    // @Value(value = "${local.server.port}")
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenUrl_whenGetProducts_thenAStringExists() throws Exception {
    }

    @Test
    public void givenUrl_whenGetProducts_thenAProductExists() throws Exception {
    }

    @Test
    public void givenAProduct_whenPostWithHeader_thenSuccess() throws URISyntaxException {
    }

}
