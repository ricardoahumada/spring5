package com.banana.persistence;

import com.banana.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepositoryData extends JpaRepository<Student, Long> {
    public List<Student> findByNombreIgnoreCaseOrderByCursoAsc(String nombre);
}
