package com.banana.persistence.project.mysql2;

import com.banana.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepositoryData2 extends JpaRepository<Project, Long> {
}
