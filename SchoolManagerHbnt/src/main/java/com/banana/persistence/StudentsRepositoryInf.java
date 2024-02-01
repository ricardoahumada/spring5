package com.banana.persistence;

import com.banana.models.Student;

public interface StudentsRepositoryInf {
    public void add(Student estudiante);
    public Student update(Student estudiante);
    public Student get(int idx);
    public Student getById(Long id);

    public String getUrlConn();
}
