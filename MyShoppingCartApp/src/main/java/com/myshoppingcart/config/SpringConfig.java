package com.myshoppingcart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({ReposConfig.class, ServicesConfig.class})
@ComponentScan(basePackages = {"com.myshoppingcart.persistence", "com.myshoppingcart.service"})
@PropertySource("classpath:config.properties")
public class SpringConfig {
}
