package com.banana.services;

import com.banana.models.Student;

public interface IStudentService {
    public Student getStudentByIndex(int idx);
    public Student getStudentById(Long id);
}
