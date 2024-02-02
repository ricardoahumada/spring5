package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicioMensajeriaTest {

    IServicioMensajeria servicio;

    @Test
    void dadoRemitenteYDestinatarioYTextoValido_cuandoEnviarMensaje_entoncesMensajeValido() throws Exception {
        Usuario remitente = new Usuario(1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, true);
        String texto = "Felices Fiestas!";
        Mensaje message = servicio.enviarMensaje(remitente, destinatario, texto);
        assertThat(message.getId(), greaterThan(0));
    }

    @Test
    void dadoRemitenteYDestinatarioYTextoNOValido_cuandoEnviarMensaje_entoncesExcepcion() {
        Usuario remitente = new Usuario(1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, true);
        String texto = "SMS < 10";
        assertThrows(MensajeException.class, () -> {
            servicio.enviarMensaje(remitente, destinatario, texto);
        });
    }


    @Test
    void dadoRemitenteYDestinatarioValido_cuandoMostrarChatConUsuario_entoncesListaMensajes() throws Exception {
        Usuario remitente = new Usuario(1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, true);

        List<Mensaje> userMessages = servicio.mostrarChatConUsuario(remitente, destinatario);
        assertNotNull(userMessages);
    }

    @Test
    void dadoRemitenteYDestinatarioNOValido_cuandoMostrarChatConUsuario_entoncesExcepcion() throws Exception {
        Usuario remitente = new Usuario(1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, false);
        assertThrows(UsuarioException.class, () -> {
            List<Mensaje> userMessages = servicio.mostrarChatConUsuario(remitente, destinatario);
        });
    }

    @Test
    void dadoRemitenteYDestinatarioValido_cuandoBorrarChatConUsuario_entoncesOK() {
        Usuario remitente = new Usuario(1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, true);
        boolean borrarChat = servicio.borrarChatConUsuario(remitente, destinatario);
        assertTrue(borrarChat);
    }

    @Test
    void dadoRemitenteYDestinatarioNOValido_cuandoBorrarChatConUsuario_entoncesExcepcion() {
        Usuario remitente = new Usuario(1, null, null, null, true);
        Usuario destinatario = new Usuario(2, null, null, null, false);
        assertThrows(UsuarioException.class, () -> {
            boolean borrarChat = servicio.borrarChatConUsuario(remitente, destinatario);
        });
    }
}