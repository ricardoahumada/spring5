package com.netmind;

import com.netmind.config.FirstConfiguration;
import com.netmind.config.SecondConfiguration;
import com.netmind.config.ThirdConfiguration;
import com.netmind.modelos.Message;
import com.netmind.modelos.Usuario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnotations {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(FirstConfiguration.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(SecondConfiguration.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(ThirdConfiguration.class);

        // Message obj = (Message) context.getBean("unMensaje");
        Message obj = context.getBean(Message.class);
        System.out.println(obj);

        Usuario user = context.getBean(Usuario.class);
        System.out.println(user);

    }
}
