package com.myshoppingcart.config;

import com.myshoppingcart.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ReposConfig {


    @Value("${db_url}")
    String connUrl;


    /*@Bean
    public ICompraRepository createICompraRepository() {
         CompraDBRepository repo = new CompraDBRepository();
         repo.setConnUrl(connUrl);
         return repo;
    }*/

    @Bean
    public IProductoRepository createIProductoRepository() {
        ProductoDBRepository repo = new ProductoDBRepository();
        repo.setConnUrl(connUrl);
        return repo;
    }

    @Bean
    @Profile("prod")
    public IUsuarioRepository createDBUsuarioRepository() {
        System.out.println("usando UsuarioDBRepository...");
        UsuarioDBRepository repo = new UsuarioDBRepository();
        repo.setDb_url(connUrl);
        return repo;
    }

    @Bean
    @Profile({"default", "dev"})
    public IUsuarioRepository createInMemUsuarioRepository() {
        System.out.println("usando UsuarioInMemoryRepository...");
        UsuarioInMemoryRepository repo = new UsuarioInMemoryRepository();
        return repo;
    }

}
