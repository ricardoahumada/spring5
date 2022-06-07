package com.javatunes.view;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Catalog cat = context.getBean(Catalog.class);

        MusicItem musicItem = cat.findById(3L);
        System.out.println(musicItem);
    }
}
