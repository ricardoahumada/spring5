package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.School;
import com.banana.models.Student;
import com.banana.persistence.school.SchoolsRepositoryData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class SchoolsRepositoryDataTest {
    @Autowired
    SchoolsRepositoryData repo;

    @PersistenceContext
    private EntityManager em;


    @Test
    void add() throws SQLException {
        School sch = new School(null, "Mi escuela jpa", null);
        repo.save(sch);
        assertNotNull(sch);
        assertTrue(sch.getId() > 0);

        School ssch = em.find(School.class, sch.getId());
        assertNotNull(ssch);
        assertEquals(ssch.getId(), sch.getId());

    }

    @Test
    void addWithStudents() throws SQLException {
        List<Student> estudiantes = List.of(
                new Student(null, "Juan", "Perez jpa", 2),
                new Student(null, "Luisa", "Rosalez jpa", 3)
        );

        School sch = new School(null, "Mi escuela con estudiantes jpa", estudiantes);

        for (Student estudiante : estudiantes) {
            estudiante.setMySchool(sch);
        }

        repo.save(sch);

//        System.out.println(sch);
        assertNotNull(sch);
        assertTrue(sch.getId() > 0);

    }

}