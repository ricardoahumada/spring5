package com.banana.persistence;

import com.banana.models.Project;
import com.banana.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepositoryData extends JpaRepository<Project, Long> {
}
