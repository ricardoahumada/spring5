package com.banana.bananawhatsapp.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import({RepoConfig.class, ControllerConfig.class})
@ComponentScan({"com.banana.bananawhatsapp.servicios"})
@EntityScan("com.banana.bananawhatsapp.modelos")
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.banana.bananawhatsapp.persistencia")
public class SpringConfig {

}
