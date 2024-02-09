package com.banana.persistence.extended;

import com.banana.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class CustumStudentsRepositoryImpl implements CustumStudentsRepository {

    @PersistenceContext
    EntityManager em;
    @Override
    public Student get(int idx) {
//        TypedQuery q = em.createQuery("SELECT e FROM Student e WHERE e.nombre = ?1", Student.class);
        TypedQuery q = em.createNamedQuery("Student.get", Student.class);
        q.setParameter(1, "El nuevo");
//        q.setFirstResult(idx).setMaxResults(1);
        /*List<Student> estudiantes =  q.getResultList();
        return estudiantes.get(0);*/
        return (Student) q.getSingleResult();
    }
}
