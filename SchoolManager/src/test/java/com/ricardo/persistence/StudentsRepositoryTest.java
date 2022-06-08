package com.ricardo.persistence;

import com.ricardo.config.SpringConfig;
import com.ricardo.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class StudentsRepositoryTest {

    @Autowired
    StudentsRepositoryInf respository; //= new StudentsRepository();

    @Test
    public void getAll() {
        List<Student> alumnnos = respository.getAll();
        System.out.println(alumnnos);
        assertTrue(alumnnos.size() == 5);
    }

    @Test
    public void add() {
        List<Student> alumnnos = respository.getAll();
        int prevSize = alumnnos.size();
        Student ultimo = alumnnos.get(alumnnos.size() - 1);

        Student newAlumno = new Student("Pedro", "Roca", 3);
        respository.add(newAlumno);

        System.out.println(alumnnos);
        assertTrue(alumnnos.size() >= prevSize + 1);

        assertTrue(ultimo.getId() + 1 == newAlumno.getId());
    }

    @Test
    public void get() {
    }

    @Test
    public void getById() {
    }
}