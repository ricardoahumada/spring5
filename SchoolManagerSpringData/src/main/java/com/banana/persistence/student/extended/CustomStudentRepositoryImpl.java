package com.banana.persistence.student.extended;

import com.banana.models.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.SQLException;

@Repository
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Student get(int idx) throws SQLException {
        TypedQuery query = em.createQuery("SELECT s FROM Student s", Student.class);
        query.setFirstResult(idx).setMaxResults(1);
        Student unStd = (Student) query.getSingleResult();
        return unStd;
    }


}
