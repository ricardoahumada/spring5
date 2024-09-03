package com.banana.services;

import com.banana.models.Student;

public interface IStudentService {
    public boolean storeStudent(Student student) throws Exception;

    public Student getStudentByIndex(int idx) throws Exception;

    public Student getStudentById(Long id) throws Exception;
}
