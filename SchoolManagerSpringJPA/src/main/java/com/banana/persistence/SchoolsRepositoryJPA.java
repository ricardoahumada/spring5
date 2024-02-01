package com.banana.persistence;


import com.banana.models.School;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Getter
@Setter
@Repository
public class SchoolsRepositoryJPA implements SchoolsRepositoryInf {
    @PersistenceContext // Accede al emf; emf.createEntityManager();
    EntityManager em;

    @Override
    @Transactional
    public School add(School escuela) {
//        try {
//            em.getTransaction().begin();
        em.persist(escuela);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//            return null;
//        }
        return escuela;
    }

    @Override
    @Transactional
    public School update(School escuela){
//        try {
//            em.getTransaction().begin();
        School psch = em.find(School.class, escuela.getId());

        psch.setName(escuela.getName());
        psch.setEstudiantes(escuela.getEstudiantes());
//            em.getTransaction().commit();
        return psch;
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//            return null;
//        }
    }

    @Override
    public School getById(Long id) {
        return em.find(School.class, id);
    }
}
