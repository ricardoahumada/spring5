package com.banana.persistence;

import com.banana.models.School;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SchoolsJPARepository implements SchoolsRepositoryInf {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public School add(School escuela) {
        em.persist(escuela);
        return escuela;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public School update(School escuela) {
        School currSch = em.find(School.class, escuela.getId());
        currSch.setName(escuela.getName());
        currSch.setEstudiantes(escuela.getEstudiantes());
        return currSch;
    }

    @Override
    public School getById(Long id) {
        return em.find(School.class, id);
    }
}
