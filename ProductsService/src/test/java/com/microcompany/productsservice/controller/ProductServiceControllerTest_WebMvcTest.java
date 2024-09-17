package com.microcompany.productsservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.persistence.ProductsRepository;
import com.microcompany.productsservice.service.ProductsService;
import com.microcompany.productsservice.util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// TODO: uncomment and implement methods
@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductServiceController.class)
public class ProductServiceControllerTest_WebMvcTest {

    @BeforeEach
    public void setUp() {
        List<Product> products = List.of(new Product(1L, "Fake product", "111-222-333"));

        Mockito.when(productsService.getProductsByText("")).thenReturn(products);

        Mockito.when(productsRepository.save(Mockito.any(Product.class)))
                .thenAnswer(elem -> {
                    Product ap = (Product) elem.getArguments()[0];
                    ap.setId(100L);
                    return ap;
                });
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductsService productsService;

    @MockBean
    private ProductsRepository productsRepository;

    @Test
    public void givenProducts_whenGetProducts_thenStatus200() throws Exception {
        MvcResult result = mockMvc.perform(get("/products").accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[*].name", hasItem("Fake product")))
                .andReturn();
    }

    @Test
    void givenProducts_whenValidCreateProduct_thenIsCreatedAndHaveId() throws Exception {
        Product newProduct = new Product(null, "Nuevo producto", "123-123-1234");

        mockMvc.perform(post("/products")
                        .content(JsonUtil.asJsonString(newProduct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id", is(greaterThanOrEqualTo(1))));

    }

    @Test
    void givenProducts_whenCreateWithInvalidProduct_thenIsCreatedAndHaveId() throws Exception {
        Product newProduct = new Product(null, "Nu", "123-123-1234");

        mockMvc.perform(post("/products")
                        .content(JsonUtil.asJsonString(newProduct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isPreconditionFailed());
    }

}