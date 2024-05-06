package com.banana;

import com.banana.configuration.SpringConfig;
import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.persistence.StudentsRepositoryMongo;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("School Manager.....");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(SpringConfig.class);
        context.refresh();

        StudentsRepositoryInf repo = context.getBean(StudentsRepositoryInf.class);
        System.out.println(repo.getById(1L));

        IStudentService srv = context.getBean(IStudentService.class);
        System.out.println(srv.getStudentById(3L));


    }
}
