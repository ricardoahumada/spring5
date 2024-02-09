package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.School;
import com.banana.models.Student;
import com.banana.persistence.extended.StudentsRepositoryData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
//@ActiveProfiles("dev")
class StudentsRepositoryTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private StudentsRepositoryInf repoStudents;

    @Autowired
    private StudentsRepositoryData repoStudentsData;

    @Test
    void testBeans() {
        assertNotNull(context);
        assertNotNull(repoStudents);
        System.out.println("UrlConn: " + repoStudents.getUrlConn());
    }

    @Test
    @Transactional
    void getById() {
//        Student aStudent = repoStudents.getById(2L);
        Student aStudent = repoStudentsData.findById(1L).orElseThrow(() -> new RuntimeException());

        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 1L);
        assertNotNull(aStudent);
    }

    @Test
    void add() {
        Student newStd = new Student(null, "Juan", "Perez", 2);
//        repoStudents.add(newStd);
        repoStudentsData.save(newStd);
        System.out.println(newStd);
        Student aStudent = repoStudents.getById(newStd.getId());
        assertEquals(aStudent.getId(), newStd.getId());
    }

    @Test
    void addWithShool() {
        Student newStd = new Student(null, "El nuevo 3", "Apellido", 2, new School(null, "esccuela para el nuevo 3"), null);
        repoStudents.add(newStd);
        System.out.println(newStd);
        Student aStudent = repoStudents.getById(newStd.getId());
        assertEquals(aStudent.getId(), newStd.getId());
    }


    @Test
    void update() {
        Student aStd = new Student(1L, "Nombre Update", "Apellido Update", 2);
        System.out.println(aStd);
        Student updatedStd = repoStudents.update(aStd);
        assertEquals(updatedStd.getNombre(), aStd.getNombre());
    }

    @Test
    @Transactional
    void get() {
        Student aStudent = repoStudentsData.get(1);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 1L);
        assertNotNull(aStudent);
    }

    @Test
    @Transactional
    void findByExamples() {
        Set<Student> students = repoStudentsData.findByNombreContains("nuevo");
        System.out.println(students);
    }

    @Test
    @Transactional
    void queryExamples() {
        Set<Student> students = repoStudentsData.findByNombreEndingWith("an");
        System.out.println(students);
    }
}