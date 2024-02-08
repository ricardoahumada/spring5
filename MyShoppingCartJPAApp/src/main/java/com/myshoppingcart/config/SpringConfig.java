package com.myshoppingcart.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.myshoppingcart.persistence", "com.myshoppingcart.service"})
@PropertySource("classpath:application.properties")
@EntityScan("com.myshoppingcart.model")
//@EnableAutoConfiguration
// TODO: uncomment for spring-data
//@EnableJpaRepositories(basePackages = {"com.myshoppingcart.persistence"})
public class SpringConfig {
}
