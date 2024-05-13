package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.School;
import com.banana.models.Student;
import com.banana.persistence.school.SchoolsRepositoryInf;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnableAutoConfiguration
class SchoolsRepositoryInfTest {

    @Autowired
    private SchoolsRepositoryInf repo;

    @Autowired
    EntityManagerFactory emf;

    private EntityManager em;

    private List<School> schools = new ArrayList<>();

    @BeforeAll
    void setUp() {
        em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        for (int i = 0; i < 3; i++) {
            School ns = new School(null, "E1", null);
            em.persist(ns);
            schools.add(ns);
        }

        tx.commit();
    }

    @BeforeEach
    void before() {
        em = emf.createEntityManager();
    }

    @Test
    void add() throws SQLException {
        School sch = new School(null, "Mi escuela", null);
        repo.add(sch);
        assertNotNull(sch);
        assertTrue(sch.getId() > 0);

        School ssch = em.find(School.class, sch.getId());
        assertNotNull(ssch);
        assertEquals(ssch.getId(), sch.getId());

        schools.add(sch);
    }

    @Test
    void addWithStudents() throws SQLException {
        List<Student> estudiantes = List.of(
            new Student(null, "Juan", "Perez", 2),
            new Student(null, "Luisa", "Rosalez", 3)
        );

        School sch = new School(null, "Mi escuela con estudiantes", estudiantes);

        for (Student estudiante : estudiantes) {
            estudiante.setMySchool(sch);
        }

        repo.add(sch);
//        System.out.println(sch);
        assertNotNull(sch);
        assertTrue(sch.getId() > 0);

    }

    @Test
    void update() throws SQLException {
        School schToChange = schools.get(0);
        School sch = new School(schToChange.getId(), "Mi escuela cambio", null);
        School schC = repo.update(sch);
        assertNotNull(sch);
        assertEquals(sch.getName(), schC.getName());
    }

    @Test
    @Transactional
    void getById() throws SQLException {
//        School schToFind = schools.get(0);
        School sch = repo.getById(4L);
        System.out.println(sch);
        assertNotNull(sch);
    }

    @Test
    @Transactional
    void getAll() throws SQLException {
        List<School> escuelas = repo.getAll();
        System.out.println(escuelas);

        assertNotNull(escuelas);
        assertTrue(escuelas.size() >= schools.size());
    }

    @AfterAll
    void tearDown() {
        em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        for (School school : schools) {
            School as = em.find(School.class, school.getId());
            em.remove(as);
        }

        tx.commit();
    }


}