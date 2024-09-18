package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.exception.NewProductException;
import com.microcompany.productsservice.exception.ProductNotfoundException;
import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.model.StatusMessage;
import com.microcompany.productsservice.persistence.ProductsRepository;
import com.microcompany.productsservice.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductServiceController implements IProductServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

    @Autowired
    ProductsService productsService;
    @Autowired
    ProductsRepository repository;

    //    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll(String text) {
        return ResponseEntity.status(HttpStatus.OK).body(productsService.getProductsByText(text != null ? text : ""));
    }

    public ResponseEntity<Product> getOne(Long id) {
        Product prod = repository.findById(id).orElseThrow(() -> new ProductNotfoundException("No existe " + id));
        return ResponseEntity.status(HttpStatus.OK).body(prod);
    }

    public ResponseEntity<Product> create(Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productsService.create(product));
    }

    public ResponseEntity updateProduct(Long id, Product aProduct) {
        aProduct.setId(id);
        repository.save(aProduct);
        if (aProduct != null) return new ResponseEntity(aProduct, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(new StatusMessage(HttpStatus.NOT_MODIFIED.value(), "No modificado"), HttpStatus.NOT_MODIFIED);
    }

    public ResponseEntity deleteProduct(Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}