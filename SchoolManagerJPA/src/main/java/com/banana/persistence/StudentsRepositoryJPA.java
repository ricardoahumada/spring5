package com.banana.persistence;


import com.banana.models.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;

@Repository
public class StudentsRepositoryJPA implements StudentsRepositoryInf {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void add(Student estudiante) throws SQLException {
        em.persist(estudiante);
    }

    @Override
    @Transactional
    public Student update(Student estudiante) throws SQLException {
        Student std = em.find(Student.class, estudiante.getId());
        std.setNombre(estudiante.getNombre());
        std.setApellido(estudiante.getApellido());
        std.setCurso(estudiante.getCurso());
        em.persist(std);
        return std;
    }

    @Override
    public Student get(int idx) throws SQLException {
        return null;
    }

    @Override
    public Student getById(Long id) throws SQLException {
        return em.find(Student.class, id);
    }
}
