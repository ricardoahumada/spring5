package com.banana.persistence.extended;

import com.banana.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface StudentsRepositoryData extends JpaRepository<Student, Long>, CustumStudentsRepository {
    public Set<Student> findByNombre(String nombre);

    public Set<Student> findByNombreContains(String nombre);

    public Student findByEscuela_Name(String name);

    @Query("SELECT s FROM Student s WHERE s.nombre LIKE %?1")
    public Set<Student> findByNombreEndingWith(String text);

}
