package com.banana.services;

import com.banana.models.Student;
import com.banana.persistence.StudentsRepositoryInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentsService implements IStudentService {
    @Autowired
    private StudentsRepositoryInf repository;

    public void setRepository(StudentsRepositoryInf repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public boolean storeStudent(Student student) throws Exception {
        if (student.isValid()) {
            repository.add(student);
            repository.getById(student.getId());
            return true;
        } else return false;
    }

    @Override
    public Student getStudentByIndex(int idx) throws Exception {
        if (idx > 0) return repository.get(idx);
        else return null;
    }

    @Override
    public Student getStudentById(Long id) throws Exception {
        if (id > 0) return repository.getById(id);
        else return null;
    }

    @Override
    public boolean storeStudentList(List<Student> students) throws Exception {
        for (Student aStd : students) {
            if (aStd.isValid()) {
                repository.add(aStd);
            } else {
                throw new Exception("Estudiante no válido:" + aStd);
            }
        }
        return true;
    }
}
