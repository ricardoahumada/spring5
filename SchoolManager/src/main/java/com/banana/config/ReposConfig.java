package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.persistence.StudentsRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
public class ReposConfig {

    @Autowired
    Environment env;

    @Value("${db.conn}")
    String dbUrl;

    @Value("${max.conn}")
    Integer maxConn;

    @Bean
    @Profile("default")
    public StudentsRepositoryInf getStudentsRepository() {
        System.out.println("maxConn:" + maxConn);

        String dbUrlEnv = env.getProperty("db.conn", String.class);
        System.out.println("dbUrlEnv:" + dbUrlEnv);

        StudentsRepository repo = new StudentsRepository();
        repo.setUrlConn(dbUrl);
        return repo;
    }

    @Bean
    @Profile("dev")
    public StudentsRepositoryInf getStudentsRepositoryJDBC() {
        System.out.println("maxConn JDBC:" + maxConn);

        String dbUrlEnv = env.getProperty("db.conn", String.class);
        System.out.println("dbUrlEnv:" + dbUrlEnv);

        StudentsRepositoryJDBC repo = new StudentsRepositoryJDBC();
        repo.setUrlConn(dbUrl);
        return repo;
    }

}
