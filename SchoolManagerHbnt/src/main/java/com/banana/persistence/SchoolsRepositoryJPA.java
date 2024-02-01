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
        try {
            em.getTransaction().begin();
            em.persist(escuela);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        }
        return escuela;
    }

    @Override
    public School update(School escuela) {
        try {
            em.getTransaction().begin();
            School psch = em.find(School.class, escuela.getId());
            psch.setName(escuela.getName());
            psch.setEstudiantes(escuela.getEstudiantes());
            em.getTransaction().commit();
            return psch;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public School getById(Long id) {
        return em.find(School.class, id);
    }
}
