package com.ricardo.services;

import com.ricardo.config.SpringConfig;
import com.ricardo.models.Student;
import com.ricardo.persistence.StudentsRepositoryInf;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class StudentsServiceTest {
    @Inject
    StudentsRepositoryInf repository;
    @Inject
    StudentServiceInf serviceInj;

    StudentsService service;

    @Before
    public void before() {
        // System.out.println("before....");
        service = new StudentsService();
        service.setRepository(repository);
    }

    @Test
    public void storeStudent() {
        List<Student> alumnos = repository.getAll();
        int repoSize = alumnos.size();

        Student nuevo = new Student("Jaime", "Jimenez", 4);
        service.storeStudent(nuevo);

        System.out.println(alumnos);

        assertTrue(alumnos.size() == repoSize + 1);

    }

    @Test
    public void storeStudentInj() {
        List<Student> alumnos = repository.getAll();
        int repoSize = alumnos.size();

        Student nuevo = new Student("Jaime", "Jimenez", 4);
        serviceInj.storeStudent(nuevo);

        System.out.println(alumnos);

        assertTrue(alumnos.size() == repoSize + 1);

    }

    @Test
    public void getStudentByIndex() {
    }

    @Test
    public void getStudentById() {
    }
}