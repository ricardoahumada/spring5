package com.myshoppingcart.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.myshoppingcart.persistence", "com.myshoppingcart.service"})
@PropertySource("classpath:config.properties")
@EntityScan("com.myshoppingcart.model")
@EnableJpaRepositories(basePackages = {"com.myshoppingcart.persistence"})
public class SpringConfig {
}
