package com.banana.persistence;


import com.banana.models.School;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;

@Getter
@Setter
public class SchoolsRepositoryJPA implements SchoolsRepositoryInf {
    EntityManager em;

    @Override
    public School add(School escuela) {

        return null;
    }

    @Override
    public School update(School escuela) {

            return null;
    }

    @Override
    public School getById(Long id) {
        return null;
    }
}
