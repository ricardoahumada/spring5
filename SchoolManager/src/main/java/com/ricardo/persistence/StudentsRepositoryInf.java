package com.ricardo.persistence;

import com.ricardo.models.Student;

import java.util.List;

public interface StudentsRepositoryInf {
    public List<Student> getAll();
    public void add(Student estudiante);
    public Student get(int idx);
    public Student getById(Long id);

}
