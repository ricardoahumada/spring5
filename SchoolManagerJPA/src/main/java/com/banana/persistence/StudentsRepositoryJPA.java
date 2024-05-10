package com.banana.persistence;


import com.banana.models.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentsRepositoryJPA implements StudentsRepositoryInf {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void add(Student estudiante) throws SQLException {
        em.persist(estudiante);
        estudiante.setNombre("Luis");
    }

    @Override
    @Transactional
    public Student update(Student estudiante) throws SQLException {
        Student std = em.find(Student.class, estudiante.getId());
        std.setNombre(estudiante.getNombre());
        std.setApellido(estudiante.getApellido());
        std.setCurso(estudiante.getCurso());
//        em.persist(std);
        return std;
    }

    @Override
    public Student get(int idx) throws SQLException {
//        TypedQuery query = em.createQuery("SELECT s FROM Student s WHERE s.nombre = :nombre ORDER BY s.id ASC", Student.class);
        TypedQuery query = em.createNamedQuery("Student.findByIdx", Student.class);
        query.setParameter("nombre","Juan");
        query.setFirstResult(idx).setMaxResults(1);
        List<Student> stds = query.getResultList();
        System.out.println(stds);
        return stds.get(0);
//        return (Student) query.getSingleResult();
    }

    @Override
    public Student getById(Long id) throws SQLException {
        return em.find(Student.class, id);
    }
}
