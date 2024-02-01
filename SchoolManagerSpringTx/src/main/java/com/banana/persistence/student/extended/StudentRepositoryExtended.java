package com.banana.persistence.student.extended;

import com.banana.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryExtended extends JpaRepository<Student, Long>, CustomStudentRepository {
}
