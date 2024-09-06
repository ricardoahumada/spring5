package com.banana.bananawhatsapp.config;

import com.banana.bananawhatsapp.persistencia.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Profile({"dev", "default"})
public class RepoConfig {

    @Bean
    IUsuarioRepository crearUsuarioRepoInMemo() {
        UsuarioInMemoryRepo repo = new UsuarioInMemoryRepo();
        return repo;
    }

    @Bean
    IMensajeRepository crearMessRepoInMemo() {
        MensajeInMemoryRepository repo = new MensajeInMemoryRepository();
        return repo;
    }

}
