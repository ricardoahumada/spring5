package com.microcompany.productsservice.service;

import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.persistence.ProductsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductsServicePureTest {


    @Mock
    ProductsRepository productsRepository;

    @InjectMocks
    ProductsService productsService;

    AutoCloseable openMocks;

    @BeforeEach
    public void setUp() {
//        openMocks = MockitoAnnotations.openMocks(this);

        List<Product> products = List.of(new Product(1L, "Fake producot", "111-222-333"));

        Mockito.when(productsRepository.findByNameContaining("")).thenReturn(products);

        Mockito.when(productsRepository.save(Mockito.any(Product.class)))
                .thenAnswer(elem -> {
                    Product ap = (Product) elem.getArguments()[0];
                    ap.setId(100L);
                    return ap;
                });
    }


    @Test
    void givenProductsWhenSearchByTextThenIsNotNull() {
        assertThat(productsService).isNotNull();

        List<Product> products = productsService.getProductsByText("");
        assertThat(products).isNotNull().isNotEmpty();

    }

    @Test
    void givenValidProduct_WhenCreate_ThenThenIsNotNull() {
        Product newProduct = new Product(null, "Nuevo Producto", "111-222-3333");

        productsService.create(newProduct);
        assertThat(newProduct)
                .isNotNull()
                .extracting(Product::getId).isEqualTo(100L);
    }

    @AfterEach
    void tearDown() throws Exception {
//        openMocks.close();
    }


}
