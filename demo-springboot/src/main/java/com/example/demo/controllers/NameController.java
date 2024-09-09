package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @Value("${spring.application.name}")
    String name;

    @RequestMapping(value = "/name")
    public String name() {
        return "Hola " + name;
    }
}
