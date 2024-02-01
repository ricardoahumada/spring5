package com.banana;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import com.banana.services.IStudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(SpringConfig.class);
        context.refresh();

        IStudentService servicioEstudiantes = context.getBean(IStudentService.class);

        Student unEstudiante = servicioEstudiantes.getStudentByIndex(3);
        System.out.println(unEstudiante);

        Student otroEstudiante = servicioEstudiantes.getStudentById(3L);
        System.out.println(otroEstudiante);

    }
}
