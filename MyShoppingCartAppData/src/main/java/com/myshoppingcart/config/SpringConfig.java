package com.myshoppingcart.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.myshoppingcart.persistence", "com.myshoppingcart.service"})
@PropertySource("classpath:config.properties")
@EntityScan("com.myshoppingcart.model")
// TODO: uncomment
//@EnableJpaRepositories(basePackages = {"com.myshoppingcart.persistence"})
@EnableAutoConfiguration
public class SpringConfig {
}
