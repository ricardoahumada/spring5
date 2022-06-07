package com.netmind.modelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Usuario {
    private String nombre;
    private String email;
//    @Inject
    @Autowired
    private MessageInf mensaje;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MessageInf getMensaje() {
        return mensaje;
    }

    public void setMensaje(MessageInf mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", mensaje=" + mensaje +
                '}';
    }
}
