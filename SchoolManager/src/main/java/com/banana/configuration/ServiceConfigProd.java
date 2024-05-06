package com.banana.configuration;

import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource("classpath:application.properties")
public class ServiceConfigProd {
    @Value("${db.conn}")
    private String dburl;
    @Bean
    @Profile("prod")
    IStudentService getStudentSvcProd(){

        System.out.println("dburl conf prod:"+dburl);
        StudentsService serv = new StudentsService();
        //serv.setRepository(repo);
        return serv;
    }
}
