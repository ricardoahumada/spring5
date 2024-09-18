package com.banana.config;

import com.banana.persistence.*;
import com.banana.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
public class ReposConfig {

    @Autowired
    Environment env;

    @Value("${max.conn}")
    Integer maxConn;

    @Autowired
    @Lazy
    EntityManagerFactory emf;

    @Bean
    @Profile("default")
    public StudentsRepositoryInf getStudentsRepository() {
        System.out.println("maxConn:" + maxConn);

        StudentsRepository repo = new StudentsRepository();
        return repo;
    }

    @Bean
    @Profile("dev")
    public StudentsRepositoryInf getStudentsRepositoryJPA() {
        System.out.println("maxConn JDBC:" + maxConn);

        StudentsRepositoryJPA repo = new StudentsRepositoryJPA();
        repo.setEm(emf.createEntityManager());
        return repo;
    }

    @Bean
    @Profile("dev")
    public SchoolsRepositoryInf getSchoolRepositoryJPA() {
        SchoolsRepositoryJPA repo = new SchoolsRepositoryJPA();
        repo.setEm(emf.createEntityManager());
        return repo;
    }

}
