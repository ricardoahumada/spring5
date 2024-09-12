package com.myshoppingcart.controller;

import com.myshoppingcart.model.Usuario;
import com.myshoppingcart.persistence.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    @Qualifier("UsuarioJPARepository")
    IUsuarioRepository repository;

    @GetMapping("")
    public ResponseEntity getAll(@RequestParam(required = false, defaultValue = "") String iniciales) {

        try {
            List<Usuario> usuarios = repository.getUsuarios(iniciales);
            if (usuarios.size() > 0) return ResponseEntity.status(HttpStatus.OK).body(usuarios);
            else return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }

    }
}
