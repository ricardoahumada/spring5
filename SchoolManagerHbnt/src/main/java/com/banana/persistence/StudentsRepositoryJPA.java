package com.banana.persistence;

import com.banana.models.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;

@Setter
@Getter
public class StudentsRepositoryJPA implements StudentsRepositoryInf {

    private String urlConn;

    private EntityManager em;

    @Override
    public void add(Student estudiante) {
        em.getTransaction().begin();
        if (estudiante.isValid()) {
            em.persist(estudiante);
            estudiante.setNombre("Cambio de nombre");
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Student update(Student estudiante) {
        em.getTransaction().begin();
        if (estudiante.isValid()) {
            Student aStd = em.find(Student.class, estudiante.getId());
            aStd.setNombre(estudiante.getNombre());
//            em.flush();
            aStd.setApellido(estudiante.getApellido());
//            em.persist(aStd);
            em.getTransaction().commit();
            return aStd;
        } else {
            em.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Student get(int idx) {
        return null;
    }

    @Override
    public Student getById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public String getUrlConn() {
        return null;
    }
}
