package com.banana.persistence.student;

import com.banana.models.Student;

import java.sql.SQLException;
import java.util.Collection;

public interface StudentsRepositoryInf {
    public void add(Student estudiante) throws SQLException;

    public Student update(Student estudiante) throws SQLException;

    public Student get(int idx) throws SQLException;

    public Student getById(Long id) throws SQLException;

    public Collection<Student> findByKeyword(String keyword);

    public long count();

}
