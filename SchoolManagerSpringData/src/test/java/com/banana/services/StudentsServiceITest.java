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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class StudentsServiceITest {

    @Autowired
    private IStudentService service;

    @Test
    void storeStudent() throws Exception {
        Student newStd = new Student(null, "Lucas", "Lucanno", 4);
        service.storeStudent(newStd);
        System.out.println(newStd);
        assertNotNull(newStd);
        assertTrue(newStd.getId() > 0);

    }

    @Test
    void storeStudentList() throws Exception {
        List<Student> students = List.of(
                new Student(null, "Pedro", "Pierola", 5),
                new Student(null, "Luisa", "Lopez", 5),
                new Student(null, "Marta", "Martinez", 0)
        );

        boolean saved = service.storeStudentList(students);
        assertTrue(saved);
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