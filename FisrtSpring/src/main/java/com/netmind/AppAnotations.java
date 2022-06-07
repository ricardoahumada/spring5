package com.netmind;

import com.netmind.config.FirstConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnotations {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FirstConfiguration.class);

        // Message obj = (Message) context.getBean("unMensaje");
        Message obj = context.getBean(Message.class);

        System.out.println(obj);

    }
}
