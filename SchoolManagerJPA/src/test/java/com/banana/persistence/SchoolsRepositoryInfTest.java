package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.School;
import com.banana.models.Student;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
//@ActiveProfiles("dev")
// TODO: uncomment
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SchoolsRepositoryInfTest {

    @Autowired
    private SchoolsRepositoryInf repo;

    @PersistenceUnit
    EntityManagerFactory emf;

    @Test
    void testBeans() {
        assertNotNull(repo);
    }

    @PersistenceContext
    private EntityManager em;

    private List<School> schools = new ArrayList<>();

    //    @BeforeAll // TestInstance.Lifecycle.PER_CLASSTestInstance.Lifecycle.PER_CLASS
    @BeforeEach
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


    @Test
    void add() {
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
    void addwithStudents() {
        Student newStd = new Student(null, "Estudiante de Mi escuela 3", "apell", 2);
        School sch = new School(null, "Mi escuela 3", List.of(newStd));
        newStd.setEscuela(sch);

        repo.add(sch);
        assertNotNull(sch);
        assertTrue(sch.getId() > 0);

        School ssch = em.find(School.class, sch.getId());
        assertNotNull(ssch);
        assertEquals(ssch.getId(), sch.getId());

//        schools.add(sch);
    }

    @Test
    void update() {
        Long id = schools.get(0).getId();
        School sch = new School(id, "Mi escuela cambio", null);
        School schC = repo.update(sch);
        assertNotNull(sch);
        assertEquals(sch.getName(), schC.getName());
    }

    @Test
    void getById() {
        Long id = schools.get(0).getId();
        School sch = repo.getById(id);
        assertNotNull(sch);
    }


    //    @AfterAll // TestInstance.Lifecycle.PER_CLASS
    @AfterEach
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