package com.myshoppingcart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping(value = "/usuarios")
    public String getName() {
        return "usuarios";
    }
}
