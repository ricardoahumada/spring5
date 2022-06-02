package com.netmind;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");
        Message obj = (Message) context.getBean("helloWorld");
        obj.getMessage();

    }
}
