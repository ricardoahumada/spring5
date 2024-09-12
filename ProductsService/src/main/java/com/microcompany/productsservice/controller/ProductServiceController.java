package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.model.Product;
import com.microcompany.productsservice.persistence.ProductsRepository;
import com.microcompany.productsservice.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public Product getOne(@PathVariable("pid") Long id) {
        Optional<Product> opt = repository.findById(id);
        return opt.get();
//        if (opt.isPresent()) return opt.get();
//        else return null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return repository.save(product);
    }


}