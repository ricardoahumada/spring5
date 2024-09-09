package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        logger.info("Esto es un info");
        logger.warn("Esto es un warn");
        logger.error("Esto es un error");
    }


}
