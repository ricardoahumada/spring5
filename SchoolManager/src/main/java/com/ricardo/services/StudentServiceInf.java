package com.ricardo.services;

import com.ricardo.models.Student;

public interface StudentServiceInf {
    public Student getStudentByIndex(int idx);
    public Student getStudentById(Long id);
    public boolean storeStudent(Student student);
}
