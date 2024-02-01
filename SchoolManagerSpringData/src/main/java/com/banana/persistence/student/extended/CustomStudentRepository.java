package com.banana.persistence.student.extended;

import com.banana.models.Student;

import java.sql.SQLException;

public interface CustomStudentRepository {
    public Student get(int idx) throws SQLException;

}
