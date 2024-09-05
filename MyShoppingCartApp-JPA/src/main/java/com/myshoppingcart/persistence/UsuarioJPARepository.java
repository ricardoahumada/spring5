package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Component
@Setter
@Repository("UsuarioJPARepository")
public class UsuarioJPARepository implements IUsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean existeUsuario(String email, String pass) throws Exception {
        Usuario usuario = this.getUsuario(email, pass);
        return usuario != null;
    }

    @Override
    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception {
        TypedQuery query = em.createQuery("SELECT u FROM Usuario u WHERE u.email=?1 AND password=?2", Usuario.class);
        query.setParameter(1, email);
        query.setParameter(2, pass);

        Usuario usuario = (Usuario) query.getSingleResult();

        return usuario;
    }

    public List<Usuario> getUsuarios(String iniciales) throws Exception {

        TypedQuery query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE :inicial", Usuario.class);
        query.setParameter("inicial", iniciales);

        List<Usuario> users = (List<Usuario>) query.getResultList();

        return users;
    }

    @Override
    @Transactional
    public Usuario insertUsuario(Usuario nuevoUsuario) throws Exception {
        em.persist(nuevoUsuario);
        return nuevoUsuario;
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario unUsuario) throws Exception {
        em.merge(unUsuario);
        return unUsuario;
    }

    @Override
    @Transactional
    public boolean deleteUsuario(Integer uid) throws Exception {
        Usuario userToDelete = new Usuario(uid);
        em.remove(em.contains(userToDelete) ? userToDelete : em.merge(userToDelete));
        return true;
    }
}
