package com.banana.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({ServicesConfig.class/*, PersistenceConfig.class*/})
@ComponentScan(basePackages = {"com.banana.persistence", "com.banana.services"})
@PropertySource("classpath:application.properties")
@EntityScan("com.banana.models")
@EnableAutoConfiguration
public class SpringConfig {

}
