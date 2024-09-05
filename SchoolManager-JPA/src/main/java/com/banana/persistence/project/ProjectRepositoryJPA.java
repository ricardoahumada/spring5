package com.banana.persistence.project;


import com.banana.models.Project;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Getter
@Setter
@Repository
public class ProjectRepositoryJPA implements ProjectsRepositoryInf {
    @PersistenceContext // Accede al emf; emf.createEntityManager();
    EntityManager em;

    @Override
    @Transactional
    public Project add(Project proyecto) {
        em.persist(proyecto);
        return proyecto;
    }

    @Override
    @Transactional
    public Project update(Project proyecto) {
        Project psch = em.find(Project.class, proyecto.getId());

        psch.setName(proyecto.getName());
        psch.setEstudiantes(proyecto.getEstudiantes());
        return psch;
    }

    @Override
    public Project getById(Long id) {
        return em.find(Project.class, id);
    }

    @Override
    public List<Project> getAll() throws RuntimeException {
        return em.createQuery("SELECT s FROM Project s", Project.class).getResultList();
    }
}
