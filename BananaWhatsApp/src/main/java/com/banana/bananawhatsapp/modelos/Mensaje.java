package com.banana.bananawhatsapp.modelos;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Mensaje {
    private Integer id;

    private Usuario remitente;

    private Usuario destinatario;

    private String cuerpo;
    private LocalDate fecha;

    private boolean validarFecha() {
        return this.fecha != null && this.fecha.compareTo(LocalDate.now()) <= 0;
    }

    public boolean valido() throws MensajeException {
        if (remitente != null
                && destinatario != null
                && remitente.valido()
                && destinatario.valido()
                && cuerpo != null
                && cuerpo.length() > 10
                && validarFecha()
        ) return true;
        else throw new MensajeException("Mensaje no valido");
    }


}
