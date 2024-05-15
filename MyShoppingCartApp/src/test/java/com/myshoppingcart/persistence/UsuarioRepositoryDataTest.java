package com.myshoppingcart.persistence;

import com.myshoppingcart.config.SpringConfig;
import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Direccion;
import com.myshoppingcart.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
public class UsuarioRepositoryDataTest {

    @Autowired
    private UsuarioRepository repo;

    @Test
    void testBeans() {
        assertThat(repo, notNullValue());
    }

    @Test
    void dadosUsuarios_cuandoExisteUsuarioEnDB_entoncesOK() throws Exception {
        boolean existe = repo.existsByEmailAndPassword("juana@e.com", "xxxx");
        assertThat(existe, is(true));
    }

    @Test
    void dadosUsuarios_cuandoExisteUsuarioNoEnDB_entoncesNOK() throws Exception {
        boolean existe = repo.existsByEmailAndPassword("xxxx@e.com", "xxxx");
        assertThat(existe, is(false));
    }

    @Test
    void dadosUsuarios_cuandogetUsuarioEnDB_entoncesUsuario() throws Exception {
        Usuario usuario = repo.findByEmailAndPassword("juana@e.com", "xxxx");

        System.out.println(usuario);

        assertThat(usuario.getEmail(), is("juana@e.com"));

    }

    @Test
    void dadosUsuarios_cuandogetUsuariosEnDB_entoncesUsuarios() throws Exception {
        List<Usuario> usuarios = repo.getUsuarios("a");

        System.out.println(usuarios);

        assertThat(usuarios.size(), greaterThan(0));

    }

    @Test
    void dadosUsuarios_cuandogetUsuarioNoEnDB_entoncesExcepcion() {

        assertThrows(UsuarioNotFoundException.class, () -> {
            Usuario usuario = repo.findByEmailAndPassword("xxxx@e.com", "xxxx");
        });

    }

    @Test
    @Transactional
    void dadosUsuario_cuandoinsertarUsuarioEnDB_entoncesIdValido() throws Exception {
        Usuario user = new Usuario(null, "juana", "juanason", "juana@e.com", 10, 0, "xxxx", LocalDate.of(2005, 02, 01), true, new Direccion(null, "c/algria 23"));

        repo.save(user);

        System.out.println(user);

        assertThat(user.getUid(), greaterThan(0));
    }

    @Test
    void dadoUsuarioExistente_cuandoActualiza_entonces_Ok() throws Exception {
        Usuario user = repo.findByEmailAndPassword("juana@e.com", "xxxx");
        user.setApellido("Juanez");
        user.setInteres(2);

        repo.save(user);

        assertThat(user.getApellido(), is("Juanez"));
    }

    @Test
    void dadoUsuarioNoExistente_cuandoActualiza_entonces_Excepccion() throws Exception {
        Usuario user = new Usuario(null, "nuevo", "usuario", "n@n.com", 10, 0, "xxxx", LocalDate.of(2005, 02, 01), true, new Direccion(null, "c/algria 24"));
        user.setApellido("Apellido nuevo");
        user.setInteres(2);

        assertThrows(Exception.class, () -> {
            repo.save(user);
        });

    }

    @Test
    void dadoUsuario_cuandoDelete_entonces_Ok() throws Exception {
        int id = 1;
        repo.deleteById(id);
    }

}