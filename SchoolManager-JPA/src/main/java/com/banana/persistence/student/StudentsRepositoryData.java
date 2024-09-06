package com.banana.persistence.student;

import com.banana.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepositoryData extends JpaRepository<Student, Long> {
}
