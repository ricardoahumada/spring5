package com.banana.services;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class StudentsServiceITest {

    @Autowired
    private IStudentService service;

    @Test
    void storeStudent() {
    }

    @Test
    void getStudentByIndex() {
    }

    @Test
    void getStudentById() throws Exception {
        Student std = service.getStudentById(1L);
        System.out.println(std);
        assertNotNull(std);
    }
}