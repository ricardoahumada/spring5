package com.javatunes.service;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.MusicItem;
import org.junit.Test;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CatalogTest {
    @Inject
    Catalog cat;

    @Test
    public void findById() {
        MusicItem item = cat.findById(1L);
        System.out.println(item);
        assertTrue(1L == item.getId());
    }

    @Test
    public void persist() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void testFindById() {
    }

    @Test
    public void findByKeyword() {
    }

    @Test
    public void findByCategory() {
    }
}