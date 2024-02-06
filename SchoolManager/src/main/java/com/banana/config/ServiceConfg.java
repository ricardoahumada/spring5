package com.banana.config;

import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfg {

    @Autowired
    StudentsRepositoryInf repo;

    @Bean
    public IStudentService getStudentService(){
        StudentsService stdSrvc = new StudentsService();
        stdSrvc.setRepository(repo);
        return stdSrvc;
    }

}
