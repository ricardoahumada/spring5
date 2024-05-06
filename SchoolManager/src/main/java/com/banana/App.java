package com.banana;

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
        context.register(StudentsRepository.class);
        context.register(StudentsRepositoryMongo.class);
        context.register(StudentsService.class);
        context.refresh();

        // Object repo = context.getBean("repomongo");
        // System.out.println(repo);

        IStudentService srv = context.getBean(IStudentService.class);
        System.out.println(srv.getStudentById(3L));


    }
}
