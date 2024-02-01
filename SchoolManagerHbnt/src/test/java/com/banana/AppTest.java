package com.banana;

import com.banana.config.SpringConfig;
import com.banana.util.JPAUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})

public class AppTest {

    private EntityManager entityManager;

    @BeforeEach
    public void setUp() throws Exception {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
    }

    @AfterEach
    public void tearDown() {
//        entityManager.getTransaction().rollback();
        entityManager.close();
    }

    @Test
    public void load() {
        assertTrue(true);
    }


}