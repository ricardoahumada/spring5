package com.banana.config;

import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {
    @Autowired
    StudentsRepositoryInf repo;

    @Value("${db.comm}")
    private String urlConn;

    @Bean
    public IStudentService getService() {
        System.out.println("urlConn:" + urlConn);
        StudentsService srv = new StudentsService();
        srv.setRepository(repo);
        return srv;
    }
}
