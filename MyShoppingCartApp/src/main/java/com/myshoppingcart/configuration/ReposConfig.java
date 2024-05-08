package com.myshoppingcart.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.myshoppingcart.persistence"})
@PropertySource("classpath:config.properties")
public class ReposConfig {
}
