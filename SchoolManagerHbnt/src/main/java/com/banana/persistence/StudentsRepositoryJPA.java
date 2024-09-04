package com.banana.persistence;

import com.banana.models.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;

@Setter
@Getter
public class StudentsRepositoryJPA implements StudentsRepositoryInf {

    private EntityManager em;

    @Override
    public void add(Student estudiante) {
        em.getTransaction().begin();
        if(estudiante.isValid()) {
            em.persist(estudiante);
            em.getTransaction().commit();
        }else{
            em.getTransaction().rollback();
        }

    }

    @Override
    public Student update(Student estudiante) {
        em.getTransaction().begin();

        Student std = getById(estudiante.getId());
        std.setNombre(estudiante.getNombre());
        std.setApellido(estudiante.getApellido());
        std.setCurso(estudiante.getCurso());

//        em.persist(std);
        em.flush();

        std.setNombre("Nombre cambiado");

        em.getTransaction().commit();

        return std;
    }

    @Override
    public Student get(int idx) {
        return null;
    }

    @Override
    public Student getById(Long id) {
        return em.find(Student.class, id);
    }


}
