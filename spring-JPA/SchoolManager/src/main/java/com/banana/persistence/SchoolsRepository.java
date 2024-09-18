package com.banana.persistence;

import com.banana.models.School;

import java.util.HashSet;
import java.util.Set;

public class SchoolsRepository implements SchoolsRepositoryInf {
    private final Set<School> escuelas = new HashSet<>();

    public SchoolsRepository() {
        escuelas.add(new School(1L, "Mariposa"));
    }

    @Override
    public School add(School escuela) {
        escuelas.add(escuela);
        return escuela;
    }

    @Override
    public School update(School escuela) {
        for (School sc : escuelas) {
            if (sc.getId() == escuela.getId()) {
                sc = escuela;
                return sc;
            }
        }
        return null;
    }

    @Override
    public School getById(Long id) {
        for (School sc : escuelas) {
            if (sc.getId() == id) return sc;
        }
        return null;
    }
}
