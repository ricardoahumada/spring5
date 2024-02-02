package com.banana.bananawhatsapp.config;

import com.banana.bananawhatsapp.persistencia.IUsuarioRepository;
import com.banana.bananawhatsapp.persistencia.UsuarioInMemoryRepo;
import com.banana.bananawhatsapp.persistencia.UsuarioJDBCRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class RepoConfig {

    @Value("${db_url}")
    String connUrl;

    @Bean
    @Profile("prod")
    IUsuarioRepository crearUsuarioRepoJDBC(){
        UsuarioJDBCRepo repo = new UsuarioJDBCRepo();
        repo.setDb_url(connUrl);
        return repo;
    }

    @Bean
    @Profile("dev")
    IUsuarioRepository crearUsuarioRepoInMemo(){
        UsuarioInMemoryRepo repo = new UsuarioInMemoryRepo();
        return repo;
    }
}
