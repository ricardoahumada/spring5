package com.myshoppingcart.config;

import com.myshoppingcart.persistence.IUsuarioRepository;
import com.myshoppingcart.persistence.UsuarioDBRepository;
import com.myshoppingcart.persistence.UsuarioInMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RepoConfig {

    @Bean
    @Profile({"dev","default"})
    public IUsuarioRepository createUsuarioMemRepo() {
        return new UsuarioInMemoryRepository();
    }

   /* @Bean
    @Profile("prod")
    public IUsuarioRepository createUsuarDBRepo() {
        return new UsuarioDBRepository();
    }*/
}
