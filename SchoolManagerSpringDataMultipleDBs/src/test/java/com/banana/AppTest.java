package com.banana;

import com.banana.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
public class AppTest {

    @PersistenceContext(unitName = "school-mysql")
    EntityManager em1;
    @PersistenceContext(unitName = "school-h2")
    EntityManager em2;

    @PersistenceContext(unitName = "school-mysql2")
    EntityManager em3;

    @Test
    public void load() {
        assertNotNull(em1);
        assertNotNull(em2);
        assertNotNull(em3);
        assertTrue(true);
    }


}