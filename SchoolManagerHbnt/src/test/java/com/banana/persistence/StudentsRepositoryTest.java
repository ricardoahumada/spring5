package com.banana.persistence;

import com.banana.config.SpringConfig;
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

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@ActiveProfiles("dev")
class StudentsRepositoryTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private StudentsRepositoryInf repoStudents;

   /* @BeforeEach
//    @BeforeAll
    void setUp() {
//        context = new ClassPathXmlApplicationContext("beans.xml");
        context = new AnnotationConfigApplicationContext(StudentsRepository.class);
        repoStudents = context.getBean(StudentsRepositoryInf.class);
    }*/

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
        Student newStd = new Student(null, "El nuevo", "Apellido", 2);
        System.out.println(newStd);
        repoStudents.add(newStd);
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
    void get() {
        Student aStudent = repoStudents.get(2);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 3L);
        assertNotNull(aStudent);
    }
}