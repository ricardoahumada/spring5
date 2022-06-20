/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.netmind.config;

import com.netmind.persistence.AlmacenCoches;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan({"com.netmind.persistence"})
public class SpringConfig {
    @Bean
    public AlmacenCoches createAlmancenCochesBean(){
        return new AlmacenCoches();
    }
}