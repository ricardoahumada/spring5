package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryParaTests {

    @Value("${db_curl}")
    private String db_url;

    public Usuario getById(Integer id) {
        return null;
    }
}
