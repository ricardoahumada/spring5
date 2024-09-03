package com.banana;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("School Manager.....");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        StudentsRepositoryInf repo = context.getBean(StudentsRepository.class);
        System.out.println(repo.getById(1L));

        IStudentService service = context.getBean(StudentsService.class);
        System.out.println(service.getStudentById(1L));

    }
}
