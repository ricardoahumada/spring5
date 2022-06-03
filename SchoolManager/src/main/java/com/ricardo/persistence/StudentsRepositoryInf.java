package com.ricardo.persistence;

import com.ricardo.models.Student;

public interface StudentsRepositoryInf {
    public void add(Student estudiante);
    public Student get(int idx);
    public Student getById(Long id);

}
