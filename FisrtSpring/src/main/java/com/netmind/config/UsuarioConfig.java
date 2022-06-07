package com.netmind.config;

import com.netmind.modelos.Message;
import com.netmind.modelos.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
public class UsuarioConfig {
    @Inject
    Message unMensaje;

    @Bean
    public Usuario createUser(){
        Usuario user= new Usuario();
        user.setEmail("r@r.com");
        user.setNombre("Ricardo");
        user.setMensaje(unMensaje);
        return user;
    }
}
