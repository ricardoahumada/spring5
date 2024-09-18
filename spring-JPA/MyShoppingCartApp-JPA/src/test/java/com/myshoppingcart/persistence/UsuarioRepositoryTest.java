package com.myshoppingcart.persistence;

import com.myshoppingcart.config.SpringConfig;
import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
//@ActiveProfiles("dev")
@EnableAutoConfiguration
public class UsuarioRepositoryTest {

    @Autowired
//    @Qualifier("UsuarioDBRepository")
    @Qualifier("UsuarioJPARepository")
    private IUsuarioRepository repo;

    @Test
    void testBeans() {
        assertThat(repo, notNullValue());
    }

    @Test
    void dadosUsuarios_cuandoExisteUsuarioEnDB_entoncesOK() throws Exception {
        boolean existe = repo.existeUsuario("juana@e.com", "juanason_1");
        assertThat(existe, is(true));
    }

    @Test
    void dadosUsuarios_cuandoExisteUsuarioNoEnDB_entoncesNOK() throws Exception {
        boolean existe = repo.existeUsuario("xxxx@e.com", "xxxx");
        assertThat(existe, is(false));
    }

    @Test
    void dadosUsuarios_cuandogetUsuarioEnDB_entoncesUsuario() throws Exception {
        Usuario usuario = repo.getUsuario("juana@e.com", "juanason_1");

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
            Usuario usuario = repo.getUsuario("xxxx@e.com", "xxxx");
        });

    }

    @Test
    void dadosUsuario_cuandoinsertarUsuarioEnDB_entoncesIdValido() throws Exception {
        Usuario user = new Usuario(null, "nuevo", "usuario", "n@n.com", 10, 2000, "xxxx", LocalDate.of(2005, 02, 01), true);

        repo.insertUsuario(user);

        System.out.println(user);

        assertThat(user.getUid(), greaterThan(0));
    }

    @Test
    void dadoUsuarioExistente_cuandoActualiza_entonces_Ok() throws Exception {
        Usuario user = repo.getUsuario("n@n.com", "xxxx");
        user.setApellido("Juanez");
        user.setInteres(2);

        repo.updateUsuario(user);

        assertThat(user.getApellido(), is("Juanez"));
    }

    @Test
    void dadoUsuarioNoExistente_cuandoActualiza_entonces_Excepccion() throws Exception {
        Usuario user = new Usuario(null, "nuevo", "usuario", "n@n.com", 10, 0, "xxxx", LocalDate.of(2005, 02, 01), true);
        user.setApellido("Apellido nuevo");
        user.setInteres(2);

        assertThrows(Exception.class, () -> {
            repo.updateUsuario(user);
        });

    }

    @Test
    void dadoUsuario_cuandoDelete_entonces_Ok() throws Exception {
        int id = 1;
        boolean ok = repo.deleteUsuario(id);

        assertThat(ok, is(true));
    }

}