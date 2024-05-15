package com.banana.persistence.project.mysql1;

import com.banana.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepositoryData1 extends JpaRepository<Project, Long> {
}
