package com.banana.configuration;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.banana.persistence"})
public class SpringConfig {

    /*@Bean
    StudentsRepositoryInf getStudentRepo(){
        return new StudentsRepository();
    }*/

    /*@Autowired
    StudentsRepositoryInf repo;¡*/

    @Bean
    IStudentService getStudentSvc(){
        StudentsService serv = new StudentsService();
        //serv.setRepository(repo);
        return serv;
    }

}
