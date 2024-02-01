package com.banana.persistence;

import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentsRepositoryTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private StudentsRepositoryInf repoStudents;

    @Test
    void testBeans() {
        assertNotNull(context);
        assertNotNull(repoStudents);
        System.out.println("UrlConn: " + repoStudents.getUrlConn());
    }

    @Test
    void getById() {
        Student aStudent = repoStudents.getById(1L);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 1L);
        assertNotNull(aStudent);
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