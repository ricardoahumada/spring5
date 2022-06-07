package com.netmind.config;

import com.netmind.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan( "com.netmind")
public class FirstConfiguration {

    @Bean
    public Message createMessage(){
        Message unMensaje= new Message();
        unMensaje.setMessage("Hola! Esto es un mensaje...");
        return  unMensaje;
    }

}
