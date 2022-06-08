package com.ricardo.services;

import com.ricardo.models.School;
import com.ricardo.persistence.SchoolsRepository;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolServiceTest {

    @Test
    public void getSchoolById() {
        SchoolService service= new SchoolService();
        service.setRepo(new SchoolsRepository());

        School school= service.getSchoolById(1L);
        assertNotNull(school);
    }
}