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
        Student newStd = new Student(null, "Matias", "Mattel", 2);
        boolean isOk = service.storeStudent(newStd);
        assertTrue(isOk);
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

    @Test
    void storeStudentList() {
        List<Student> estudiantes = List.of(
                new Student(null, "Juan", "Juanez", 2),
                new Student(null, "Luisa", "Rosalez", 3),
                new Student(null, "Pedro", "Perez", 1),
                new Student(null, "Maria", "Marianez", 2),
                new Student(null, "Rosa", "Lopez", 1)
        );

        boolean isOk = false;
        try {
            isOk = service.storeStudentList(estudiantes);
        } catch (Exception e) {
            System.out.println("Error al almacenar alumnos");
        }

        assertTrue(isOk);
    }
}