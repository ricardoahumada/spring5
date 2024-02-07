package com.myshoppingcart.config;

import com.myshoppingcart.persistence.IUsuarioRepository;
import com.myshoppingcart.persistence.UsuarioInMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {

    @Bean("userimr")
    public IUsuarioRepository createUsuarioMemRepo() {
        return new UsuarioInMemoryRepository();
    }
}
