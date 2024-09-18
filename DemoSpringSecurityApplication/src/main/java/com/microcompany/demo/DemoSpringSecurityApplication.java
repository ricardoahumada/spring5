package com.microcompany.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoSpringSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSecurityApplication.class, args);
    }

}
