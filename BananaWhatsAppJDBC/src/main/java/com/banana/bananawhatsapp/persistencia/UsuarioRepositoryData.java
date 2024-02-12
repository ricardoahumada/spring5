package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.Set;

@Profile({"prod","default"})
public interface UsuarioRepositoryData extends JpaRepository<Usuario, Integer> {

    public default Usuario crear(Usuario usuario) throws SQLException {
        usuario.valido();
        return save(usuario);
    }

    public default Usuario actualizar(Usuario usuario) throws SQLException {
        usuario.valido();
        return save(usuario);
    }

    public default boolean borrar(Usuario usuario) throws SQLException {
        deleteById(usuario.getId());
        return true;
    }

    @Query(value = "SELECT u.* FROM usuario u WHERE u.id <> ?1 LIMIT ?2", nativeQuery = true)
    public Set<Usuario> obtenerDestinatarios(Integer id, int max);


    public default Set<Usuario> obtenerPosiblesDestinatarios(Integer id, int max) throws SQLException {
        if (id <= 0 || max < 1) throw new UsuarioException("Parámetros imválidos");
        else return obtenerDestinatarios(id, max);
    }
}
