package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.util.DBUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServicioUsuariosTest {

    IServicioUsuarios servicio;

    @BeforeEach
    void cleanAndReloadData() {
        DBUtil.reloadDB();
    }

    @Test
    void dadoUnUsuarioValido_cuandoCrearUsuario_entoncesUsuarioValido() throws Exception {
        Usuario nuevo = new Usuario(null, "Ricardo", "r@r.com", LocalDate.now(), true);
        servicio.crearUsuario(nuevo);

        assertThat(nuevo, notNullValue());
        assertThat(nuevo.getId(), greaterThan(0));
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoCrearUsuario_entoncesExcepcion() {
        Usuario nuevo = new Usuario(null, "Ricardo", "r", LocalDate.now(), true);
        assertThrows(UsuarioException.class, () -> {
            servicio.crearUsuario(nuevo);
        });
    }

    @Test
    void dadoUnUsuarioValido_cuandoBorrarUsuario_entoncesUsuarioValido() {
        Usuario user = new Usuario(2, "Gema", "g@g.com", LocalDate.now(), true);
        boolean userDelete = servicio.borrarUsuario(user);
        assertThat(userDelete, is(true));
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoBorrarUsuario_entoncesExcepcion() {
        Usuario user = new Usuario(-1, "John", "j@j.com", LocalDate.now(), false);
        assertThrows(UsuarioException.class, () -> {
            servicio.borrarUsuario(user);
        });
    }

    @Test
    void dadoUnUsuarioValido_cuandoActualizarUsuario_entoncesUsuarioValido() {
        Integer iDUser = 1;
        Usuario user = new Usuario(iDUser, "Juan", "j@j.com", LocalDate.now(), true);
        Usuario userUpdate = servicio.actualizarUsuario(user);
        assertThat(userUpdate.getEmail(), is("j@j.com"));
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoActualizarUsuario_entoncesExcepcion() {
        Usuario user = new Usuario(1, "Juan", "j@j.com", LocalDate.now(), false);
        assertThrows(UsuarioException.class, () -> {
            servicio.actualizarUsuario(user);
        });
    }

    @Test
    void dadoUnUsuarioValido_cuandoObtenerPosiblesDesinatarios_entoncesUsuariosValidos() {
        int numPosibles = 100;
        Usuario user = new Usuario(1, "Juan", "j@j.com", LocalDate.now(), true);

        Set<Usuario> conjuntoDestinatarios = servicio.obtenerPosiblesDesinatarios(user, numPosibles);
        assertThat(conjuntoDestinatarios.size(), lessThanOrEqualTo(numPosibles));
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoObtenerPosiblesDesinatarios_entoncesExcepcion() {
        Usuario user = new Usuario(-1, null, null, null, true);
        int numPosibles = 100;
        assertThrows(UsuarioException.class, () -> {
            servicio.obtenerPosiblesDesinatarios(user, numPosibles);
        });
    }
}