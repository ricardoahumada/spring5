package com.microcompany.productsservice.controller;

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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

    @Autowired
    ProductsService productsService;
    @Autowired
    ProductsRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAll(@RequestParam(required = false) String text) {
        return productsService.getProductsByText(text != null ? text : "");
    }

    /*@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public Product getOne(@PathVariable("pid") Long id) {
        Optional<Product> opt = repository.findById(id);
//        return opt.get();
        if (opt.isPresent()) return opt.get();
        else return null;
    }*/
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public ResponseEntity getOne(@PathVariable("pid") Long id) {
        Optional<Product> opt = repository.findById(id);
        if (opt.isPresent()) return new ResponseEntity(opt.get(), HttpStatus.OK);
        else return new ResponseEntity(new StatusMessage(HttpStatus.NOT_FOUND.value(), "No existe"), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return repository.save(product);
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@PathVariable("pid") Long id, @RequestBody Product aProduct) {
        aProduct.setId(id);
        repository.save(aProduct);
        if (aProduct != null) return new ResponseEntity(aProduct, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(new StatusMessage(HttpStatus.NOT_MODIFIED.value(), "No modificado"), HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@PathVariable("pid") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}