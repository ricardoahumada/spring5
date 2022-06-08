package com.ricardo.services;

import com.ricardo.models.School;
import com.ricardo.persistence.SchoolsRepository;
import com.ricardo.persistence.SchoolsRepositoryInf;

public class SchoolService implements SchoolServiceInf {
    private SchoolsRepositoryInf repo;

    public void setRepo(SchoolsRepositoryInf repo) {
        this.repo = repo;
    }

    public School getSchoolById(Long id) {
        if (id > 0) return repo.getById(id);
        else return null;
    }
}
