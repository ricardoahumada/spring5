package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.Project;
import com.banana.models.Student;
import com.banana.persistence.project.ProjectsRepositoryInf;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@TestMethodOrder( MethodOrderer.OrderAnnotation.class)
@EnableAutoConfiguration
class ProjectsRepositoryInfTest {

    @Autowired
    ProjectsRepositoryInf repo;

    @Test
    @Order(1)
    void add() throws SQLException {
        Project newProject = new Project(null, "Project 1", null);
        repo.add(newProject);
        assertThat(newProject, notNullValue());
        assertThat(newProject.getId(), greaterThan(0L));
    }

    @Test
    @Order(2)
    void addclasswithstudents() throws SQLException {
        List<Student> students = List.of(
                new Student(null, "Luisa", "Perez", 2),
                new Student(null, "Luis", "Perez", 3)
        );
        Project newProject = new Project(null, "Project 2", students);
        repo.add(newProject);
        System.out.println(newProject);

        assertThat(newProject, notNullValue());
        assertThat(newProject.getEstudiantes(), notNullValue());
        assertThat(newProject.getEstudiantes().size(), greaterThan(0));
    }

    @Test
    @Order(3)
    @Transactional
    void getAll() throws SQLException {
        List<Project> classes = repo.getAll();
        assertThat(classes, notNullValue());
        System.out.println(classes);
        assertThat(classes.size(), greaterThan(0));
    }

    @Test
    @Order(4)
    @Transactional
    void getById() throws SQLException {
        Project aProject = repo.getById(4L);
        System.out.println(aProject);
        assertThat(aProject, notNullValue());
    }

    @Test
    @Order(5)
    void update() throws SQLException {
        String newName = "New Project Name";
        Project aProject = new Project(1L, newName, null);
        repo.update(aProject);
        System.out.println("aProject: "+aProject);
        assertThat(aProject, notNullValue());
        assertThat(aProject.getName(), is(newName));
    }

}