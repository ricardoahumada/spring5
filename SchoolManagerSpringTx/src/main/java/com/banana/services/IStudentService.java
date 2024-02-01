package com.banana.services;

import com.banana.models.Student;

import java.sql.SQLException;
import java.util.Collection;

public interface IStudentService {
    public boolean storeStudent(Student student) throws Exception;

    public Student getStudentByIndex(int idx) throws Exception;

    public Student getStudentById(Long id) throws Exception;

    public Collection<Student> findByKeyword(String keyword) throws Exception;

    public long size();

    public void saveCollection(Collection<Student> students) throws Exception;
}
