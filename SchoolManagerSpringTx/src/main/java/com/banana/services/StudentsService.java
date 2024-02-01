package com.banana.services;

import com.banana.models.Student;
import com.banana.persistence.student.StudentsRepositoryInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;

@Service
public class StudentsService implements IStudentService {
    @Autowired
    private StudentsRepositoryInf repository;

    public void setRepository(StudentsRepositoryInf repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean storeStudent(Student student) throws Exception {
        if (student.isValid()) {
            repository.add(student);
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
    public Collection<Student> findByKeyword(String keyword) throws Exception {
        return repository.findByKeyword(keyword);
    }

    @Override
    public long size() {
        return repository.count();
    }

    @Override
    @Transactional
    public void saveCollection(Collection<Student> students) throws Exception {
        for (Student aStudent : students) {
            System.out.println("Attempting to save " + aStudent);
            repository.add(aStudent);
        }
        System.out.println("Batch terminó normalmentee!");
    }
}
