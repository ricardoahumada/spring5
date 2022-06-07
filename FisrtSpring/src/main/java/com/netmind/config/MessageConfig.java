package com.netmind.config;

import com.netmind.modelos.Message;
import com.netmind.modelos.MessageInf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    @Bean
    public Message createMessage(){
        Message unMensaje= new Message();
        unMensaje.setMessage("Hola! Esto es un mensaje...");
        return  unMensaje;
    }

}
