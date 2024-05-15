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
    EntityManager em;

    @PersistenceContext(unitName = "school-h2")
    EntityManager em2;

    @Test
    public void load() {
        assertNotNull(em);
        assertNotNull(em2);
        assertTrue(true);
    }




}