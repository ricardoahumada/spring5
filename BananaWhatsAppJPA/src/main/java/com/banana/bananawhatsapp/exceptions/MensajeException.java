package com.banana.bananawhatsapp.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MensajeException extends RuntimeException {
    public MensajeException(String message) {
        super(message);
    }
}
