package com.netmind;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");

        try {
            Message obj = (Message) context.getBean("aMessage");
            String mss= obj.getMessage();
            System.out.println("Your Message : " + mess);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
