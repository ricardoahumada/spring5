package com.banana.services;

import com.banana.models.Student;

import java.util.List;

public interface IStudentService {
    public boolean storeStudent(Student student) throws Exception;

    public Student getStudentByIndex(int idx) throws Exception;

    public Student getStudentById(Long id) throws Exception;

    public boolean storeStudentList(List<Student> students) throws Exception;

}
