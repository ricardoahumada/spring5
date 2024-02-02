package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.config.SpringConfig;
import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@ActiveProfiles("prod")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MensajeRepositoryTest {

    @Autowired
    IMensajeRepository repo;

    @Test
    void dadoUnMensajeValido_cuandoCrear_entoncesMensajeValido() throws Exception {
        Usuario remitente = new Usuario(1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, true);

        Mensaje message = new Mensaje(null, remitente, destinatario, "De acuerdo Juana. Un saludo.", LocalDate.now());

        repo.crear(message);
        assertThat(message, notNullValue());
        assertThat(message.getId(), greaterThan(0));
    }

    @Test
    void dadoUnMensajeNOValido_cuandoCrear_entoncesExcepcion() throws Exception {
        Usuario remitente = new Usuario(1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, true);
        Mensaje message = new Mensaje(null, destinatario, remitente, "SMS < 10", LocalDate.now());
        assertThrows(MensajeException.class, () -> {
            repo.crear(message);
        });
    }

    @Test
    void dadoUnUsuarioValido_cuandoObtener_entoncesListaMensajes() throws Exception {
        Usuario user = new Usuario(1, null, null, null, true);

        List<Mensaje> userMessages = repo.obtener(user);
        assertNotNull(userMessages);
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoObtener_entoncesExcepcion() throws Exception {
        Usuario user = new Usuario(-1, null, null, null, true);

        assertThrows(UsuarioException.class, () -> {
            List<Mensaje> userMessages = repo.obtener(user);
        });
    }

    @Test
    void dadoUnRemitenteValido_cuandoBorrarEntre_entoncesOK() throws Exception {
        Usuario remitente = new Usuario(1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, true);

        boolean borrarChat = repo.borrarEntre(remitente, destinatario);
        assertTrue(borrarChat);
    }

    @Test
    void dadoUnRemitenteNOValido_cuandoBorrarEntre_entoncesExcepcion() throws Exception {
        Usuario remitente = new Usuario(-1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, true);

        assertThrows(UsuarioException.class, () -> {
            repo.borrarEntre(remitente, destinatario);
        });
    }

    @Test
    void dadoUnUsuarioValido_cuandoBorrarTodos_entoncesOK() throws Exception {
        Usuario user = new Usuario(1, null, null, null, true);

        boolean borrarChat = repo.borrarTodos(user);
        assertTrue(borrarChat);
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoBorrarTodos_entoncesExcepcion() throws Exception {
        Usuario user = new Usuario(-1, null, null, null, true);

        assertThrows(UsuarioException.class, () -> {
            repo.borrarTodos(user);
        });
    }

}