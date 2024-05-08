package com.banana.persistence;

import com.banana.configuration.SpringConfig;
import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
@ActiveProfiles("prod")
class StudentsRepositoryTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private StudentsRepositoryInf repoStudents;

    @Test
    void testBeans() {
        assertNotNull(context);
        assertNotNull(repoStudents);
    }

    @Test
    void getById() {
        Student aStudent = repoStudents.getById(1L);
        System.out.println(aStudent);
        assertNotNull(aStudent);
        assertEquals(aStudent.getId(), 1L);
    }

    @Test
    void add() {
        Student newStd = new Student(6L, "El nuevo", "Apellido", 2);
        System.out.println(newStd);
        repoStudents.add(newStd);
        Student aStudent = repoStudents.getById(6L);
        assertEquals(aStudent.getId(), 6L);
    }

    @Test
    void get() {
        Student aStudent = repoStudents.get(2);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 3L);
        assertNotNull(aStudent);
    }
}