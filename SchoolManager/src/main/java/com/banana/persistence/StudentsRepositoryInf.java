package com.banana.persistence;

import com.banana.models.Student;

public interface StudentsRepositoryInf {
    void add(Student estudiante);
    Student get(int idx);
    Student getById(Long id);
    Student update(Student estudiante);
}
