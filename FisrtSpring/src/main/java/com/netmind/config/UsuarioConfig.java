package com.netmind.config;

import com.netmind.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public Usuario createUser(){
        Usuario user= new Usuario();
        return user;
    }
}
