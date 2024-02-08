package com.banana.persistence;

import com.banana.models.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentJPARepository implements StudentsRepositoryInf {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void add(Student estudiante) {
        em.persist(estudiante);
    }

    @Override
    @Transactional
    public Student update(Student estudiante) {

        Student currStdn = em.find(Student.class, estudiante.getId());

        currStdn.setNombre(estudiante.getNombre());
        currStdn.setApellido(estudiante.getApellido());
        currStdn.setCurso(estudiante.getCurso());

        return currStdn;
    }

    @Override
    public Student get(int idx) {
        TypedQuery q = em.createQuery("SELECT e FROM Student e WHERE e.nombre = ?1", Student.class);
        q.setParameter(1,"El nuevo");
//        q.setFirstResult(idx).setMaxResults(1);
        /*List<Student> estudiantes =  q.getResultList();
        return estudiantes.get(0);*/
        return (Student) q.getSingleResult();
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
