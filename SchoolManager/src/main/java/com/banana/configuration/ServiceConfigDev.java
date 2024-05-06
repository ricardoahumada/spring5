package com.banana.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile({"default","dev"})
@PropertySource("classpath:application-dev.properties")
public class ServiceConfigDev {
    @Value("${db.conn}")
    private String dburl;

    @Bean
    @Profile({"dev","default"})
    IStudentService getStudentSvc(){

        System.out.println("dburl conf dev:"+dburl);
        StudentsService serv = new StudentsService();
        //serv.setRepository(repo);
        return serv;
    }
}
