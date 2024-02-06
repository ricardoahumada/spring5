package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public StudentsRepositoryInf getRepoStudents() {
        return new StudentsRepository();
    }

    @Autowired
    StudentsRepositoryInf repoStd;

    @Bean
    public IStudentService getSrvcStudents() {

        StudentsService stdSrv = new StudentsService();
        stdSrv.setRepository(repoStd);
        return stdSrv;
    }

}
