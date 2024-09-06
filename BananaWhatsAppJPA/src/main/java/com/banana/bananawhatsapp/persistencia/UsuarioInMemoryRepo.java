package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Usuario;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UsuarioInMemoryRepo implements IUsuarioRepository {

    Set<Usuario> usuarios = new HashSet<>();
    private Integer num = 0;

    @Override
    public Usuario obtener(int id) throws SQLException {
        return null;
    }

    @Override
    public Usuario crear(Usuario usuario) throws SQLException {
        usuario.valido();
        usuario.setId(num + 1);
        usuarios.add(usuario);

        return usuario;
    }

    @Override
    public Usuario actualizar(Usuario usuario) throws SQLException {
        return null;
    }

    @Override
    public boolean borrar(Usuario usuario) throws SQLException {
        return false;
    }

    @Override
    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws SQLException {
        return null;
    }
}
