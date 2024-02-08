package com.banana.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({ServicesConfig.class})
@ComponentScan(basePackages = {"com.banana.persistence", "com.banana.services"})
@PropertySource("classpath:application.properties")
//@Import({StudentsRepository.class, StudentsService.class})
public class SpringConfig {

}
