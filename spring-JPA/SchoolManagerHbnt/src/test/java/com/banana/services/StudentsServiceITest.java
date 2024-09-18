package com.banana.services;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import com.banana.persistence.StudentsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class StudentsServiceITest {
    @Autowired
    private ApplicationContext context;

    @Autowired
//    private IStudentService service;
    private StudentsService service;

    @Test
    void testBeans() {
        assertNotNull(context);
        assertNotNull(service);
//        System.out.println("repo: "+service.getRepository());
    }

    @Test
    void storeStudent() {
    }

    @Test
    void getStudentByIndex() {
    }

    @Test
    void getStudentById() {
        Student std = service.getStudentById(1L);
        System.out.println(std);
        assertNotNull(std);
    }
}