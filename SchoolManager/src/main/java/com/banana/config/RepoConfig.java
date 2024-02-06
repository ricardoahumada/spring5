package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {
    @Bean
    // @Qualifier("inmemsr")
    public StudentsRepositoryInf getRepoStudents() {
        return new StudentsRepository();
    }
}
