package com.banana.persistence;

import com.banana.models.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectsRepositoryInf {
    public Project add(Project project) throws SQLException;

    public Project update(Project project) throws SQLException;

    public Project getById(Long id) throws SQLException;

    public List<Project> getAll() throws SQLException;
}
