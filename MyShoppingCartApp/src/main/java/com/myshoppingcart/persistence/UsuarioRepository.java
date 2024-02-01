package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public boolean existsByEmailAndPassword(String email, String password);
    public Usuario findByEmailAndPassword(String email, String password);

    @Query("SELECT u from Usuario u WHERE u.nombre LIKE ?1% OR u.apellido LIKE ?1%")
    public List<Usuario> getUsuarios(String iniciales);
}
