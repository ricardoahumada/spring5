package com.microcompany.productsservice.dto;

import com.microcompany.productsservice.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ProductMapperTest {

    @Test
    void productToProductDto() {
        //given
        Product product = new Product(1L, "escoba", "123-345-1234");

        //when
        ProductDTO productDto = ProductMapper.INSTANCE.productToProductDto(product);

        System.out.println("productDto:"+productDto);

        //then
        assertThat(productDto).isNotNull();
        assertThat(productDto.getNombre()).isEqualTo(product.getName());
        assertThat(productDto.getNumSerie()).isEqualTo(product.getSerial());
    }


    @Test
    void productDtoToProduct() {
        //given
        ProductDTO productDto = new ProductDTO(1L, "escoba", "123-345-1234");

        //when
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);

        System.out.println("product:"+product);

        //then
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo(productDto.getNombre());
        assertThat(product.getSerial()).isEqualTo(productDto.getNumSerie());
    }


    @Test
    void productsToProductDtos() {
        //given
        List<Product> products = List.of(
                new Product(1L, "escoba", "123-345-1234"),
                new Product(2L, "pala", "123-345-1235")
        );

        //when
        List<ProductDTO> productDtos = (List<ProductDTO>) ProductMapper.INSTANCE.productsToProductDtos(products);

        System.out.println("productDtos:"+productDtos);

        //then
        assertThat(productDtos).isNotNull();

        int idx = 0;
        for (ProductDTO productDto : productDtos) {
            assertThat(productDto.getNombre()).isEqualTo(products.get(idx++).getName());
        }

    }

    @Test
    void productDtosToProducts() {

        //given
        List<ProductDTO> productDtos = List.of(
                new ProductDTO(1L, "escoba", "123-345-1234"),
                new ProductDTO(2L, "pala", "123-345-1235")
        );

        //when
        List<Product> products = (List<Product>) ProductMapper.INSTANCE.productDtosToProducts(productDtos);

        System.out.println("products:"+products);

        //then
        assertThat(productDtos).isNotNull();

        int idx = 0;
        for (Product product : products) {
            assertThat(productDtos.get(idx++).getNombre()).isEqualTo(product.getName());
        }
    }


}