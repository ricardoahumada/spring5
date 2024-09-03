package com.banana.config;

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

    @Autowired
    StudentsRepositoryInf repo;

    @Bean
    public IStudentService getService(){
        StudentsService srv = new StudentsService();
        srv.setRepository(repo);
        return  srv;
    }

}
