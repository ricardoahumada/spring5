package com.banana.services;

import com.banana.models.Student;
import com.banana.persistence.StudentsRepositoryInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service
public class StudentsService implements IStudentService {
    @Autowired
    private StudentsRepositoryInf repository;

    public void setRepository(StudentsRepositoryInf repository) {
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
