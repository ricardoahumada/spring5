package com.ricardo.services;

import com.ricardo.models.School;
import com.ricardo.models.Student;

public interface SchoolServiceInf {
    public School getSchoolById(Long id);
    void addSchool(School school);

    void addSchoolAndFirstStudent(School school, Student student);
}
