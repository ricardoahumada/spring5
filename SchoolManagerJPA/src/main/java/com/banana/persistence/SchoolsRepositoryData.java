package com.banana.persistence;

import com.banana.models.Project;
import com.banana.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolsRepositoryData extends JpaRepository<School, Long> {
}
