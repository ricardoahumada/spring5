package com.banana.persistence;

import com.banana.models.Student;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsRepositoryData extends JpaRepository<Student, Long> {
    public List<Student> findByNombreIgnoreCaseOrderByCursoAsc(String nombre);
    @Query("Select s FROM Student s WHERE nombre = :nombre Order By s.curso Asc")
    public List<Student> findByNombreIgnoreCaseOrderByCursoAsc2(@Param("nombre") String nombre);
}
