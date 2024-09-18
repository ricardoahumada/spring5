package com.banana.services;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class StudentsServiceITest {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private IStudentService service;

    @Test
    void testBeans() {
        assertNotNull(context);
        assertNotNull(service);
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