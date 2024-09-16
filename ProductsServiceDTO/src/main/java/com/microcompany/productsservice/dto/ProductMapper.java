package com.microcompany.productsservice.dto;

import com.microcompany.productsservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper

public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "serial", target = "numSerie")
    ProductDTO productToProductDto(Product product);

    @Mapping(target = "name", source = "nombre")
    @Mapping(target = "serial", source = "numSerie")
    Product productDtoToProduct(ProductDTO productDto);

    public Collection<ProductDTO> productsToProductDtos(Collection<Product> producs);

    public Collection<Product> productDtosToProducts(Collection<ProductDTO> productDtos);

}