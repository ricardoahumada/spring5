package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.config.SpringConfig;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@ActiveProfiles("prod")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsuarioRepositoryTest {
    @Autowired
    IUsuarioRepository repo;

    @Autowired
    IMensajeRepository mensajeRepository;

    @BeforeAll
    void setUp(){
        // inserts
    }

    @Test
    @Order(1)
    void dadoUnUsuarioValido_cuandoCrear_entoncesUsuarioValido() throws Exception {
        Usuario nuevo = new Usuario(null, "Ricardo", "r@r.com", LocalDate.now(), true);
        repo.crear(nuevo);

        assertThat(nuevo, notNullValue());
        assertThat(nuevo.getId(), greaterThan(0));
    }

    @Test
    @Order(2)
    void dadoUnUsuarioNOValido_cuandoCrear_entoncesExcepcion() {
        Usuario nuevo = new Usuario(null, "Ricardo", "r", LocalDate.now(), true);
        assertThrows(Exception.class, () -> {
            repo.crear(nuevo);
        });
    }

    @Test
    @Order(3)
    void dadoUnUsuarioValido_cuandoActualizar_entoncesUsuarioValido() {
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoActualizar_entoncesExcepcion() {
    }

    @Test
    void dadoUnUsuarioValido_cuandoBorrar_entoncesOK() throws SQLException {
        Usuario user = new Usuario(1, null, null, null, true);
        boolean ok = repo.borrar(user);

        assertTrue(ok);
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoBorrar_entoncesExcepcion() {
        Usuario user = new Usuario(-1, null, null, null, true);
        assertThrows(Exception.class, () -> {
            repo.borrar(user);
        });
    }

    @Test
    void dadoUnUsuarioValido_cuandoObtenerPosiblesDestinatarios_entoncesLista() {
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoObtenerPosiblesDestinatarios_entoncesExcepcion() {
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoCrearListarBorrar_entoncesOK(){
        // insert
        // verificar que id mayor 0
        
        // get
        // verificar que existe para id

        // delete
        // verificar que excepcion cuando id

    }

}