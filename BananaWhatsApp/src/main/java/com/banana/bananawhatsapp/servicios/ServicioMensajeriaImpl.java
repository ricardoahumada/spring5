package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.IMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioMensajeriaImpl implements IServicioMensajeria {
    @Autowired
    private IMensajeRepository mensajeRepo;

    @Override
    public Mensaje enviarMensaje(Usuario remitente, Usuario destinatario, String texto) throws UsuarioException, MensajeException {
        try {
            Mensaje mensajeAEnviar = new Mensaje(null, remitente, destinatario, texto, LocalDate.now());
            mensajeAEnviar.valido();
            return mensajeRepo.crear(mensajeAEnviar);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Mensaje> mostrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
        try {
            remitente.valido();
            destinatario.valido();
            List<Mensaje> mensajesRemitente = mensajeRepo.obtener(remitente);

            return mensajesRemitente.stream().filter(aM -> aM.getDestinatario().getId() == destinatario.getId()).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean borrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
        try {
            return mensajeRepo.borrarEntre(remitente, destinatario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
