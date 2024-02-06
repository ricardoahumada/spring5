package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.banana.persistence", "com.banana.services"})
public class SpringConfig {

    @Bean
    // @Qualifier("inmemsr")
    public StudentsRepositoryInf getRepoStudents() {
        return new StudentsRepository();
    }


}
