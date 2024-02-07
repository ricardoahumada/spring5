package com.banana.persistence;

import com.banana.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class StudentJPARepository implements StudentsRepositoryInf {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public void add(Student estudiante) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();
    }

    @Override
    public Student update(Student estudiante) {
        return null;
    }

    @Override
    public Student get(int idx) {
        return null;
    }

    @Override
    public Student getById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Student.class, id);
    }

    @Override
    public String getUrlConn() {
        return null;
    }
}
