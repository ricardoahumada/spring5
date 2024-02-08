package com.banana.services;

import com.banana.models.Student;

public interface IStudentService {
    Student getStudentByIndex(int idx);
    Student getStudentById(Long id);
}
