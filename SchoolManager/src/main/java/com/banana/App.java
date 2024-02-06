package com.banana;

import com.banana.config.SpringConfig;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        StudentsRepositoryInf repo = context.getBean("inmemsr", StudentsRepositoryInf.class);
        System.out.println(repo.getById(1L));

        IStudentService servicio = context.getBean(IStudentService.class);
        System.out.println(servicio.getStudentById(1L));

    }
}
