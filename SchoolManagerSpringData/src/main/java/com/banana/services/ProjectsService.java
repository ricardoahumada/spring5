package com.banana.services;


import com.banana.models.Project;
import com.banana.persistence.project.mysql1.ProjectRepositoryData1;
import com.banana.persistence.project.mysql2.ProjectRepositoryData2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService {

    @Autowired
    ProjectRepositoryData1 repo1;
    @Autowired
    ProjectRepositoryData2 repo2;
    public addProject(Project project){
        Project newProject = new Project(null, "Project 1", null);
    }

}
