package com.banana.persistence.student;

import com.banana.models.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;

@Repository
public class StudentRepository implements StudentsRepositoryInf {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(Student estudiante) throws SQLException {
        if (estudiante.isValid()) em.persist(estudiante);
        else {
            System.out.println("**** !!!Estudiante no válido:" + estudiante);
            throw new SQLException("Estudiante no válido:" + estudiante);
        }
    }

    @Override
    @Transactional
    public Student update(Student estudiante) throws SQLException {
        return null;
    }

    @Override
    public Student get(int idx) throws SQLException {
//        TypedQuery query = em.createQuery("SELECT s FROM Student s", Student.class);
        Query query = em.createNamedQuery("Student.selectall");
        /*List<Student> lista = query.getResultList();
        return lista.get(idx);*/
        return (Student) query.setFirstResult(idx).setMaxResults(1).getSingleResult();

        /*TypedQuery query = em.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class);
        query.setParameter("id", 3L);
        return (Student) query.getSingleResult();*/
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Student getById(Long id) throws SQLException {
        return em.find(Student.class, id);
    }
}
