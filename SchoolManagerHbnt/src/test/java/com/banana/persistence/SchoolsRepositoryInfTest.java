package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.School;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@ActiveProfiles("dev")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SchoolsRepositoryInfTest {

    @Autowired
    private SchoolsRepositoryInf repo;

    @Autowired
    EntityManagerFactory emf;

    /*@Test
    void testBeans(){
        assertNotNull(repo);
    }*/

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
    void update() {
        School sch = new School(1L, "Mi escuela cambio", null);
        School schC = repo.update(sch);
        assertNotNull(sch);
        assertEquals(sch.getName(), schC.getName());
    }

    @Test
    void getById() {
        School sch = repo.getById(1L);
        assertNotNull(sch);
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