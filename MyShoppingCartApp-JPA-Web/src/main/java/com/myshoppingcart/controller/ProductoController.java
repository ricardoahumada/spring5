package com.myshoppingcart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @RequestMapping(value = "/productos")
    public String getName() {
        return "productos";
    }
}
