package com.banana.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class HolaController {

    Logger logger = LoggerFactory.getLogger(HolaController.class);

    @Value("${user.myname:Ricardo}")
    String name;

    @RequestMapping("")
    public String hola() {
        logger.info("Método hola");
        logger.warn("Método hola WARN");
        logger.error("Método hola ERROR");
        return "Hola " + name + "!!";
    }

    @RequestMapping("/quetal")
    public String hdy() {
        return "qué tal?";
    }

}
