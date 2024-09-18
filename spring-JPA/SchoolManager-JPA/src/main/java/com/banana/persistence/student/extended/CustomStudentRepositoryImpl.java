package com.banana.persistence.student.extended;

import com.banana.models.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;

@Repository
public class CustomStudentRepositoryImpl implements CustomStudentRepository {
    @PersistenceContext
    private EntityManager em;

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
}
