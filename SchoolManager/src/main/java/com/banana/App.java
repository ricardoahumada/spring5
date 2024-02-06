package com.banana;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentsRepositoryInf repo = context.getBean("studentRepo", StudentsRepository.class);
        System.out.println(repo.getById(1L));

    }
}
