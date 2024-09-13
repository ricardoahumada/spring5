package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.assembler.ProductModelAssembler;
import com.microcompany.productsservice.exception.ProductNotfoundException;
import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.model.StatusMessage;
import com.microcompany.productsservice.persistence.ProductsRepository;
import com.microcompany.productsservice.resource.ProductResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

    @Autowired
    ProductsRepository productsRepo;

    @Autowired
    private ProductModelAssembler productModelAssembler;


    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ProductResource>> getAllProducts() {
        List<Product> productEntities = productsRepo.findAll();
        System.out.println("productEntities:" + productEntities);
//        return new ResponseEntity(productModelAssembler.toCollectionModel(productEntities), HttpStatus.OK);
        return new ResponseEntity(productModelAssembler.toModel(productEntities), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getProduct(@PathVariable @Min(1) Long id) {
        if (!productsRepo.existsById(id)) throw new ProductNotfoundException();
        return productsRepo.findById(id)
                .map(productModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody @Valid Product newProduct) {
        newProduct.setId(null);
        productsRepo.save(newProduct);
        if (newProduct != null && newProduct.getId() > 0)
            return new ResponseEntity<>(productModelAssembler.toModel(newProduct), HttpStatus.CREATED);
        else
            return new ResponseEntity<>(new StatusMessage(HttpStatus.BAD_REQUEST.value(), "No encontrado"), HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@PathVariable @Min(1) Long id, @RequestBody @Valid Product aProduct) {
        aProduct.setId(id);
        productsRepo.save(aProduct);
        if (aProduct != null) return new ResponseEntity(productModelAssembler.toModel(aProduct), HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(new StatusMessage(HttpStatus.NOT_MODIFIED.value(), "No modificado"), HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable @Min(1) Long id) {
        productsRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}