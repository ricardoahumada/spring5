package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.School;
import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class StudentsRepositoryInfTest {
    @Autowired
    private StudentsRepositoryInf repoStudents;

    @Test
    void getById() throws SQLException {
        Student aStudent = repoStudents.getById(1L);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 1L);
        assertNotNull(aStudent);
    }

    @Test
    void add() throws SQLException {
        Student newStd = new Student(null, "Matias", "Mattel", 2);
        System.out.println(newStd);
        repoStudents.add(newStd);
        Student aStudent = repoStudents.getById(newStd.getId());
        assertEquals(aStudent.getId(), newStd.getId());
    }

    @Test
    void addwithschool() throws SQLException {
        Student newStd = new Student(null, "Rita", "Narvaez", 2, new School(null, "Otra escuela", null), null);
        System.out.println(newStd);
        repoStudents.add(newStd);
        Student aStudent = repoStudents.getById(newStd.getId());
        assertEquals(aStudent.getId(), newStd.getId());
    }


    @Test
    void update() throws SQLException {
        Student aStd = new Student(1L, "Nombre Update", "Apellido Update", 2);
        System.out.println(aStd);
        Student updatedStd = repoStudents.update(aStd);
        assertEquals(updatedStd.getNombre(), aStd.getNombre());
    }

    @Test
    void get() throws SQLException {
        Student aStudent = repoStudents.get(2);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 3L);
        assertNotNull(aStudent);
    }
}