package com.banana.persistence.student;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class StudentsRepositoryDataTest {

    @Autowired
    StudentsRepositoryData repoStudents;

    @Test
    void getById() throws SQLException {
//        Student aStudent = repoStudents.getById(1L);
        Optional<Student> op = repoStudents.findById(1L);
        Student aStudent = op.get();
        System.out.println("aStudent:" + aStudent);

        assertEquals(aStudent.getId(), 1L);
        assertNotNull(aStudent);
    }

    @Test
    void getAll() throws SQLException {
        List<Student> students = repoStudents.findAll();
        System.out.println("students:" + students);
        assertNotNull(students);
    }

    @Test
    void save() throws SQLException {
        Student newStd = new Student(null, "Matias", "Mattel", 2);
        System.out.println(newStd);
        repoStudents.save(newStd);
        Student aStudent = repoStudents.getById(newStd.getId());
        assertEquals(aStudent.getId(), newStd.getId());
    }

    @Test
    void getAllByName() throws SQLException {
        List<Student> students = repoStudents.findByNombreIgnoreCase("Juan");
        System.out.println("students:" + students);
        assertNotNull(students);
    }

    @Test
    void getAllByNameAndSurn() throws SQLException {
        List<Student> students = repoStudents.findByNombreAndApellidoIgnoreCase("juan", "perez");
        System.out.println("students:" + students);
        assertNotNull(students);
    }

    @Test
    void findByNombrEndsWith() throws SQLException {
        List<Student> students = repoStudents.findByNombreWith("n");
        System.out.println("students:"+students);
        assertNotNull(students);
    }

/*

    @Test
    void findByNombreWithNative() throws SQLException {
        List<Student> students = repoStudents.findByNombreWithNative("n");
        System.out.println("students:"+students);
        assertNotNull(students);
    }*/
}