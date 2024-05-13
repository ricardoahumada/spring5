package com.banana.persistence.student;

import com.banana.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsRepositoryData extends JpaRepository<Student, Long> {
    public List<Student> findByNombre(String nombre);
    public List<Student> findByNombreIgnoreCase(String nombre);
    public List<Student> findByNombreAndApellidoIgnoreCase(String nombre, String apellido);

    @Query("SELECT s FROM Student s WHERE s.nombre LIKE %:name%")
    public List<Student> findByNombreWith(@Param("name") String trozodenombre);

    @Query(value = "SELECT s.* FROM estudiante s WHERE s.name LIKE %:name%", nativeQuery = true)
    public List<Student> findByNombreWithNative(@Param("name") String trozodenombre);
}
