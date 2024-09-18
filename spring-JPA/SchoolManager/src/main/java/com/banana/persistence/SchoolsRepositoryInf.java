package com.banana.persistence;

import com.banana.models.School;

public interface SchoolsRepositoryInf {
    School add(School escuela);

    School update(School escuela);

    School getById(Long id);
}
