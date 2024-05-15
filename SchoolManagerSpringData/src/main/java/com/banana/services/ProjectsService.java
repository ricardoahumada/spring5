package com.banana.services;


import com.banana.models.Project;
import com.banana.persistence.project.mysql1.ProjectRepositoryData1;
import com.banana.persistence.project.mysql2.ProjectRepositoryData2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectsService {

    @Autowired
    ProjectRepositoryData1 repo1;
    @Autowired
    ProjectRepositoryData2 repo2;
    @Transactional("transactionManagerMysql")
    public void addProject(Project project){
        addProjectDB1(project);
        addProjectDB2(project);
    }

    @Transactional("transactionManagerMysql")
    private void addProjectDB1(Project project) {
        repo1.save(project);
    }

    @Transactional("transactionManagerMysql2")
    private void addProjectDB2(Project project) {
        repo2.save(project);
    }

}
