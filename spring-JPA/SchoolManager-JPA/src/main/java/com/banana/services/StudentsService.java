package com.banana.services;

import com.banana.models.Student;
import com.banana.persistence.student.StudentsRepositoryInf;
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
    @Transactional
    public boolean storeStudentList(List<Student> students) throws Exception {
        int i = 1;
        for (Student aStd : students) {
//            if (aStd.isValid()) {
            System.out.println("**** Procesando estudiante: " + i);
            try {
                repository.add(aStd);
            } catch (Exception e) {
                System.out.println("**** !!!Estudiante no válido Exception:" + e.getMessage());
            }
//            } else {
//                System.out.println("**** !!!Estudiante no válido:" + aStd);
//                throw new Exception("Estudiante no válido:" + aStd);
//            }
            i++;
        }
        return true;
    }
}
