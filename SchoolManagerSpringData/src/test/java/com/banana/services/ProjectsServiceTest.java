package com.banana.services;

import com.banana.config.SpringConfig;
import com.banana.models.Project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class ProjectsServiceTest {

    @Autowired
    ProjectsService service;

    @Test
    void addProject() {
        Project newProject = new Project(null, "Project 1", null);
        service.addProject(newProject);
        assertTrue(true);
    }
}