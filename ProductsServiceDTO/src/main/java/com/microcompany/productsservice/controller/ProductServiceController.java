package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.dto.ProductDTO;
import com.microcompany.productsservice.dto.ProductMapper;
import com.microcompany.productsservice.exception.ProductNotfoundException;
import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.model.StatusMessage;
import com.microcompany.productsservice.persistence.ProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

    @Autowired
    ProductsRepository productsRepo;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Collection<ProductDTO>> getAllProducts() {
        Collection<ProductDTO> productDTOS = ProductMapper.INSTANCE.productsToProductDtos(productsRepo.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getProduct(@PathVariable @Min(1) Long id) {
        return productsRepo.findById(id)
                .map(ProductMapper.INSTANCE::productToProductDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ProductNotfoundException());
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody @Valid ProductDTO newProduct) {
        newProduct.setId(null);
        Product savedProduct = productsRepo.save(ProductMapper.INSTANCE.productDtoToProduct(newProduct));
        return new ResponseEntity<>(ProductMapper.INSTANCE.productToProductDto(savedProduct), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@PathVariable @Min(1) Long id, @RequestBody @Valid ProductDTO aProduct) {
        aProduct.setId(id);
        Product savedProduct = productsRepo.save(ProductMapper.INSTANCE.productDtoToProduct(aProduct));
        return new ResponseEntity<>(ProductMapper.INSTANCE.productToProductDto(savedProduct), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable @Min(1) Long id) {
        productsRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}