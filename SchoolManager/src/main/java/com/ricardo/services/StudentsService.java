package com.ricardo.services;

import com.ricardo.models.Student;
import com.ricardo.persistence.StudentsRepository;
import com.ricardo.persistence.StudentsRepositoryInf;

public class StudentsService implements StudentServiceInf{
    private StudentsRepositoryInf repository;

    public void setRepository(StudentsRepository repository) {
        this.repository = repository;
    }

    public boolean storeStudent(Student student) {
        if (student.isValid()) {
            repository.add(student);
            return true;
        } else return false;
    }

    public Student getStudentByIndex(int idx) {
        if (idx > 0) return repository.get(idx);
        else return null;
    }

    public Student getStudentById(Long id) {
        if (id > 0) return repository.getById(id);
        else return null;
    }
}
