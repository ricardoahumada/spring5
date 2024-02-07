package com.banana.config;

import com.banana.util.JPAUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class PersistenceConfig {

    @Bean
    EntityManagerFactory createEMF() {
        return JPAUtil.getEntityManagerFactory();
    }

}
