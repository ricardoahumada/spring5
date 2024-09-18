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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// TODO: uncomment and implement methods
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("classpath:data_testing.sql")
public class ProductServiceTestRestTemplate {
    // @Value(value = "${local.server.port}")
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenUrl_whenGetProducts_thenAStringExists() throws Exception {
        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:" + port + "/products", Product[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().length).isGreaterThan(0);
//        assertThat(response.getBody()).contains("Travel");
    }

    @Test
    public void givenUrl_whenGetProducts_thenAProductExists() throws Exception {

    }

    @Test
    public void givenAProduct_whenPostWithHeader_thenSuccess() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("CONTENT-TYPE", "application/json");
        headers.set("ACCEPT", "application/json");
        Product product = new Product(null, "Nuevo producto", "111-222-3333");

        HttpEntity<Product> request = new HttpEntity<>(product, headers);
        ResponseEntity<Product> response = restTemplate.postForEntity("http://localhost:" + port + "/products", request, Product.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).extracting(Product::getId).isNotEqualTo(0);

    }

}
