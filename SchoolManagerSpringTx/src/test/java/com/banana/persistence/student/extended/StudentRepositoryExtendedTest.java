package com.banana.persistence.student.extended;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class StudentRepositoryExtendedTest {

    @Autowired
    StudentRepositoryExtended repo;

    @Test
    @Transactional
    void getById() throws RuntimeException {
        Student aStudent = repo.findById(1L).orElseThrow(() -> new RuntimeException());
        System.out.println("aStudent:" + aStudent);
        assertEquals(aStudent.getId(), 1L);
        assertNotNull(aStudent);
    }

    @Test
    void get() throws SQLException {
        Student aStudent = repo.get(2);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 3L);
        assertNotNull(aStudent);
    }

}