package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioRepository {
    public boolean existeUsuario(String email, String pass) throws Exception;

    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception;

    public List<Usuario> getUsuarios(String iniciales) throws Exception;

    public Usuario insertUsuario(Usuario nuevoUsuario) throws Exception;

    public Usuario updateUsuario(Usuario unUsuario) throws Exception;

    public boolean deleteUsuario(Integer uid) throws Exception;

}
