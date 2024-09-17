package com.microcompany.productsservice.service;

import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.persistence.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class ProductsServiceTest {

    @TestConfiguration
    static class ProductServiceConfiguration {
        @Bean
        public ProductsService productsService() {
            return new ProductsService();
        }

    }


    @BeforeEach
    public void setUp() {
        List<Product> products = List.of(new Product(1L, "Fake producot", "111-222-333"));

        Mockito.when(productsRepository.findByNameContaining("")).thenReturn(products);
    }


    @MockBean
    ProductsRepository productsRepository;

    @Autowired
    ProductsService productsService;

    @Test
    void givenProductsWhenSearchByTextThenIsNotNull() {
        assertThat(productsService).isNotNull();

        List<Product> products = productsService.getProductsByText("");
        assertThat(products).isNotNull().isNotEmpty();

    }

    @Test
    void givenValidProduct_WhenCreate_ThenThenIsNotNull() {
    }


}
