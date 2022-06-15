package com.netmind.modelos;

import org.springframework.stereotype.Component;

import javax.inject.Named;

//@Named("unMensaje")
//@Component
public class Message implements MessageInf{
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
