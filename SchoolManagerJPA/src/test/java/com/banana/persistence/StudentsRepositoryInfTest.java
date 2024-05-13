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
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class StudentsRepositoryInfTest {
    @Autowired
    private StudentsRepositoryInf repoStudents;

    @Autowired
    private StudentsRepositoryData repositoryData;

    @Test
    @Transactional
    void getById() throws SQLException {
        Student aStudent = repoStudents.getById(2L);
        System.out.println("*********" + aStudent);
        assertNotNull(aStudent);
        assertEquals(aStudent.getId(), 2L);
    }

    @Test
    @Transactional
    void getByIdData() throws SQLException {
        Student aStudent = repositoryData.findById(2L).get();
        System.out.println("*********" + aStudent);
        assertNotNull(aStudent);
        assertEquals(aStudent.getId(), 2L);
    }

    @Test
    @Transactional
    void getByNombreData() throws SQLException {
        List<Student> stds = repositoryData.findByNombreIgnoreCaseOrderByCurso("Rita");
        assertNotNull(stds);
        assertTrue(stds.size() > 0);
        System.out.println("*********" + stds);
    }

    @Test
    void add() throws SQLException {
        Student newStd = new Student(null, "Matias", "Mattel", 2);
        System.out.println("*********" + newStd);
        repoStudents.add(newStd);
        Student aStudent = repoStudents.getById(newStd.getId());
        assertEquals(aStudent.getId(), newStd.getId());
    }

    @Test
    void addData() throws SQLException {
        Student newStd = new Student(null, "Matias", "Mattel", 2);
        System.out.println("*********" + newStd);
        repositoryData.save(newStd);
        Student aStudent = repositoryData.findById(newStd.getId()).get();
        assertEquals(aStudent.getId(), newStd.getId());
    }

    @Test
    void addwithschool() throws SQLException {
        Student newStd = new Student(null, "Rita", "Narvaez", 2, new School(null, "Otra escuela", null));
        System.out.println(newStd);
        repoStudents.add(newStd);
        Student aStudent = repoStudents.getById(newStd.getId());
        assertEquals(aStudent.getId(), newStd.getId());
    }

    @Test
    void addwithschoolData() throws SQLException {
        Student newStd = new Student(null, "Rita", "Narvaez", 2, new School(null, "Otra escuela", null));
        System.out.println(newStd);
        repositoryData.save(newStd);
        Student aStudent = repositoryData.findById(newStd.getId()).get();
        assertEquals(aStudent.getId(), newStd.getId());
    }


    @Test
    void update() throws SQLException {
        Student aStd = new Student(1L, "Juan", "Juanez", 2);
        System.out.println(aStd);
        Student updatedStd = repoStudents.update(aStd);
        assertEquals(updatedStd.getNombre(), aStd.getNombre());
    }

    @Test
    void get() throws SQLException {
        Student aStudent = repoStudents.get(1);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 2L);
        assertNotNull(aStudent);
    }
}