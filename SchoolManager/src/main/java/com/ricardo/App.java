package com.ricardo;

import com.ricardo.models.Student;
import com.ricardo.services.StudentServiceInf;
import com.ricardo.services.StudentsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");

        StudentServiceInf servicioEstudiantes= context.getBean(StudentServiceInf.class);

        Student unEstudiante = servicioEstudiantes.getStudentByIndex(3);
        System.out.println(unEstudiante);

        Student otroEstudiante = servicioEstudiantes.getStudentById(3L);
        System.out.println(otroEstudiante);

    }
}
