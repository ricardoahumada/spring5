package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class UsuarioInMemoryRepository implements IUsuarioRepository {
    private static Logger logger = Logger.getLogger("UsuarioInMemoryRepository");

    private static List<Usuario> usuarios;

    public UsuarioInMemoryRepository() {
        usuarios= new ArrayList<>();

        usuarios.add(new Usuario(1, "Juana", "Juanason", "juana@e.com", 2, 20, "juanason_1", LocalDate.of(2001, 3, 5), true));
        usuarios.add(new Usuario(2, "Luisa", "Luisason", "luisa@e.com", 4, 74, "luisason_2", LocalDate.of(1996, 4, 6), true));
        usuarios.add(new Usuario(3, "Diana", "Dianason", "diana@e.com", 8, 13, "dianason_3", LocalDate.of(2010, 3, 6), true));
        usuarios.add(new Usuario(4, "Pedro", "Pedroson", "pedro@e.com", 5, 25, "pedroson_4", LocalDate.of(2000, 12, 31), true));
        usuarios.add(new Usuario(5, "Marco", "Marcoson", "marco@e.com", 6, 4, "marcoson_5", LocalDate.of(1980, 2, 13), true));
        usuarios.add(new Usuario(6, "Ricardo", "Ricardoson", "ricardo@e.com", 7, 8, "ricardoson_6", LocalDate.of(1999, 7, 25), true));
        usuarios.add(new Usuario(7, "Nora", "Norason", "nora@e.com", 1, 16, "norason_7", LocalDate.of(1995, 3, 6), true));
        usuarios.add(new Usuario(8, "Edwin", "Edwinson", "edwin@e.com", 9, 20, "edwinson_8", LocalDate.of(1992, 11, 4), true));
        usuarios.add(new Usuario(9, "Marta", "Martason", "marta@e.com", 6, 36, "martason_9", LocalDate.of(1960, 4, 5), true));
        usuarios.add(new Usuario(10, "Eduardo", "Eduardoson", "eduardo@e.com", 4, 23, "eduardoson_10", LocalDate.of(1999, 10, 8), true));
    }

    @Override
    public boolean existeUsuario(String email, String pass) {

        boolean existe = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(pass)) {
                existe = true;
                break;
            }
        }

        return existe;
    }

    @Override
    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(pass)) {
                return usuario;
            }
        }

        throw new UsuarioNotFoundException();
    }

    @Override
    public List<Usuario> getUsuarios(String iniciales) throws Exception {
        return null;
    }

    @Override
    public Usuario insertUsuario(Usuario nuevoUsuario) throws Exception {
        int newId = SecureRandom.getInstance("SHA1PRNG").nextInt();

        nuevoUsuario.setUid(newId);
        usuarios.add(nuevoUsuario);
        return nuevoUsuario;
    }

    @Override
    public Usuario updateUsuario(Usuario unUsuario) throws UsuarioNotFoundException {
        for (Usuario usuario : usuarios) {
            if (usuario.getUid() == unUsuario.getUid()) {
                usuarios.remove(usuario);
                usuarios.add(unUsuario);
                return unUsuario;
            }
        }

        throw new UsuarioNotFoundException();
    }

    @Override
    public boolean deleteUsuario(Integer uid) throws UsuarioNotFoundException {
        for (Usuario usuario : usuarios) {
            if (usuario.getUid() == uid) {
                usuarios.remove(usuario);
                return true;
            }
        }

        throw new UsuarioNotFoundException();
    }

}
