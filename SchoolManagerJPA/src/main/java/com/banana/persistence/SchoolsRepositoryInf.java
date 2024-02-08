package com.banana.persistence;

import com.banana.models.School;

public interface SchoolsRepositoryInf {
    public School add(School escuela);

    public School update(School escuela);

    public School getById(Long id);
}
