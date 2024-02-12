package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.UsuarioRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServicioImpl implements IServicioUsuarios {

    @Autowired
    UsuarioRepositoryData usuarioRepo;

    @Override
    public Usuario obtener(int id) throws UsuarioException {
            return usuarioRepo.findById(id).orElseThrow(()->new UsuarioException("Error en la obtenciónError en la obtención"));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UsuarioException {

        try {
            usuario.valido();
            usuarioRepo.crear(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioException("Error en la creación");
        }

        return usuario;
    }

    @Override
    public boolean borrarUsuario(Usuario usuario) throws UsuarioException {
        try {
            return usuarioRepo.borrar(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioException("Error en el borrado");
        }


    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws UsuarioException {
        try {
            usuario.valido();
            Usuario usuarioUpdate = usuarioRepo.actualizar(usuario);
            return usuarioUpdate;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioException("Error en la actualización");
        }
    }

    @Override
    public Set<Usuario> obtenerPosiblesDesinatarios(Usuario usuario, int max) throws UsuarioException {
        try {
            usuario.valido();
            return usuarioRepo.obtenerPosiblesDestinatarios(usuario.getId(), max);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioException("Error en obtener destinatarios");
        }
    }
}
