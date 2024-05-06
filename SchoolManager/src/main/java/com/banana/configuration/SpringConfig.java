package com.banana.configuration;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan({"com.banana.persistence"})
public class SpringConfig {

    /*@Bean
    StudentsRepositoryInf getStudentRepo(){
        return new StudentsRepository();
    }*/

    /*@Autowired
    StudentsRepositoryInf repo;¡*/

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

    @Bean
    @Profile("prod")
    IStudentService getStudentSvcProd(){

        System.out.println("dburl conf prod:"+dburl);
        StudentsService serv = new StudentsService();
        //serv.setRepository(repo);
        return serv;
    }

}
