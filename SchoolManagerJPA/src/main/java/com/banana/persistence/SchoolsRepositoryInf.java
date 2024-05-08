package com.banana.persistence;

import com.banana.models.School;

import java.sql.SQLException;
import java.util.List;

public interface SchoolsRepositoryInf {
    public School add(School escuela) throws SQLException;

    public School update(School escuela) throws SQLException;

    public School getById(Long id) throws SQLException;

    public List<School> getAll() throws SQLException;
}
