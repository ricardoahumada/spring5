package com.banana.persistence;

import com.banana.models.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Setter
@Getter
@Repository
public class StudentsRepositoryJPA implements StudentsRepositoryInf {

    @PersistenceContext  // Accede al emf; emf.createEntityManager();
    private EntityManager em;

    @Override
    @Transactional
    public void add(Student estudiante) {
        em.persist(estudiante);
    }

    @Override
    @Transactional
    public Student update(Student estudiante) {
        if (estudiante.isValid()) {
            Student aStd = em.find(Student.class, estudiante.getId());
            aStd.setNombre(estudiante.getNombre());
            aStd.setApellido(estudiante.getApellido());
            return aStd;
        } else {
            return null;
        }
    }

    @Override
    public Student get(int idx) {
        /*TypedQuery query = em.createQuery("SELECT s FROM Student s", Student.class);
//        query.setParameter("id",1L);
        query.setFirstResult(idx).setMaxResults(1); //"LIMIT idx, 1"

        // USANDO getResultList
//        List<Student> resultados = query.getResultList();
//        System.out.println("resultados:" + resultados);
//        return resultados.get(0);

        // USANDO getSingleResult
        Student unStd = (Student) query.getSingleResult();
        System.out.println("resultados:" + unStd);
        return unStd;*/

        // USANDO NamedQuery
        TypedQuery query = em.createNamedQuery("Student.getStudents", Student.class);
        query.setFirstResult(idx).setMaxResults(1); //"LIMIT idx, 1"
        List<Student> resultados = query.getResultList();
        System.out.println("resultados:" + resultados);
        return resultados.get(0);
    }

    @Override
    public Student getById(Long id) {
        return em.find(Student.class, id);
    }

}
