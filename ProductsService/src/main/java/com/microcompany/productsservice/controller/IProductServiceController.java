package com.microcompany.productsservice.controller;

import com.microcompany.productsservice.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RequestMapping("/default")
@Validated
//@CrossOrigin(origins = {"http://localhost:8080/"})
public interface IProductServiceController {

    @GetMapping("")
    public List<Product> getAll(@RequestParam(required = false) String text);


    @RequestMapping(value = "/{pid}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> getOne(@Min(1) @PathVariable("pid") Long id);

    @RequestMapping(value = "", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> create(@Valid @RequestBody Product product);

    @RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@PathVariable("pid") Long id, @RequestBody Product aProduct);

    @RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@PathVariable("pid") Long id);


}