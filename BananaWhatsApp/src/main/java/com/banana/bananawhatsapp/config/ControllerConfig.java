package com.banana.bananawhatsapp.config;

import com.banana.bananawhatsapp.controladores.ControladorUsuarios;
import com.banana.bananawhatsapp.servicios.IServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Autowired
    IServicioUsuarios userSvc;

    @Bean
    ControladorUsuarios crearUsuarioController() {
        ControladorUsuarios controller = new ControladorUsuarios();
        controller.setServicioUsuarios(userSvc);
        return controller;
    }

}
