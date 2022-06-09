package com.ricardo.persistence;

import com.ricardo.models.School;

public interface SchoolsRepositoryInf {
    public School getById(Long id);
    void storeSchool(School school);
}
