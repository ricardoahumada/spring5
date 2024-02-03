package com.banana.bananawhatsapp.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsuarioException extends RuntimeException {
    public UsuarioException(String message) {
        super(message);
    }
}
