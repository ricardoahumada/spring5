package com.ricardo.config;

import com.ricardo.persistence.SchoolsRepository;
import com.ricardo.persistence.SchoolsRepositoryInf;
import com.ricardo.services.SchoolService;
import com.ricardo.services.SchoolServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.inject.Inject;

@Configuration
public class SchoolConfig {

    @Bean
    public SchoolsRepository createRepoBean(){
        return new SchoolsRepository();
    }

    @Inject
    SchoolsRepositoryInf schoolsRepository;

    @Bean
    public SchoolService createServiceBean(){
        SchoolService schoolService = new SchoolService();
        schoolService.setRepo(schoolsRepository);
        return schoolService;
    }

}
