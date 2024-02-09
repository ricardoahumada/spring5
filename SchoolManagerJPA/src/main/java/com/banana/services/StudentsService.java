package com.banana.services;

import com.banana.models.School;
import com.banana.models.Student;
import com.banana.persistence.SchoolsRepositoryInf;
import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class StudentsService implements IStudentService {
    @Autowired
    private StudentsRepositoryInf repository;

    @Autowired
    private SchoolsRepositoryInf repoEscuela;

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

    public void actualizarEscuelaYEstudiante(Long id, String nombre, int curso){

        School escuela = repoEscuela.getById(id);
        escuela.setName(nombre);
        repoEscuela.update(escuela)
        List<Student> stds = escuela.getEstudiantes();

        for (Student std : stds) {
            std.setCurso(curso);
            repository.update(std);
        }

    }
}
