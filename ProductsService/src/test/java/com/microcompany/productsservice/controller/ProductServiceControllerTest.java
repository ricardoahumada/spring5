package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

// TODO: uncomment and implement methods
@SpringBootTest
@ActiveProfiles("testing")
@Sql(value = "classpath:data_testing.sql")
class ProductServiceControllerTest {

    @Autowired
    private IProductServiceController controller;

    @Test
    void givenProducts_whengetAllProducts_thenIsNotNull() {
        ResponseEntity<List<Product>> response = controller.getAll("");
        assertThat(response.getStatusCode().value())
                .isEqualTo(200);

        assertThat(response.getBody())
                .isNotNull()
                .isNotEmpty();

    }

    @Test
    void givenProducts_whenVaildCreateProduct_thenIsCreatedAndHaveId() {
        Product newProduct = new Product(null, "Nuevo producto", "111-222-3333");
        ResponseEntity<Product> response = controller.create(newProduct);

        assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getBody().getId()).isGreaterThan(0);
        assertThat(response.getBody()).extracting(Product::getName).isEqualTo(newProduct.getName());

    }
}