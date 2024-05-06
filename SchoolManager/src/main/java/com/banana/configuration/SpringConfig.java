package com.banana.configuration;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"com.banana.persistence"})
@Import({ServiceConfigDev.class, ServiceConfigProd.class})
public class SpringConfig {

    /*@Bean
    StudentsRepositoryInf getStudentRepo(){
        return new StudentsRepository();
    }*/

    /*@Autowired
    StudentsRepositoryInf repo;¡*/





}
