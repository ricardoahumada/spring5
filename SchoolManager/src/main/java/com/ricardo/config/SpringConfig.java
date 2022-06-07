package com.ricardo.config;

import com.ricardo.persistence.StudentsRepository;
import com.ricardo.services.StudentsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
@ComponentScan({"com.ricardo.persistence","com.ricardo.services"})
public class SpringConfig {

    /*@Bean
    public StudentsRepository getStudentsRepository(){
        StudentsRepository studentsRepository= new StudentsRepository();
        return  studentsRepository;
    }

    @Inject
    StudentsRepository studentsRepo;

    @Bean
    public StudentsService getStudentsService(){
        StudentsService studentsService= new StudentsService();
        studentsService.setRepository(studentsRepo);
        return studentsService;
    }*/
}
