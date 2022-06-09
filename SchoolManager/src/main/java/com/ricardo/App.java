package com.ricardo;

import com.ricardo.config.SpringConfig;
import com.ricardo.models.School;
import com.ricardo.models.Student;
import com.ricardo.persistence.StudentsRepository;
import com.ricardo.persistence.StudentsRepositoryInf;
import com.ricardo.services.SchoolServiceInf;
import com.ricardo.services.StudentServiceInf;
import com.ricardo.services.StudentsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        StudentServiceInf servicioEstudiantes = context.getBean(StudentServiceInf.class);

        Student unEstudiante = servicioEstudiantes.getStudentByIndex(3);
        System.out.println(unEstudiante);

        Student otroEstudiante = servicioEstudiantes.getStudentById(3L);
        System.out.println(otroEstudiante);

        //[recibir datos para] dar de alta un estudiante: nombre, apellido, curso
        // crear estudiante
        Student nuevoEstudiante = new Student("Rosa", "Rosales", 2);

        // Llamar servicio estudiantes -> storeStudent ... verificar que existe en la interface
        servicioEstudiantes.storeStudent(nuevoEstudiante);

        // schools
        SchoolServiceInf servicioEscuelas = context.getBean(SchoolServiceInf.class);
        School unaSchool = servicioEscuelas.getSchoolById(1L);
        System.out.println(unaSchool);

        // Añadir un nuevo estudiante a una escuela

        // Crear una escuela ("nombre") con su primer estudiante ("nombre, apellido, curso a la vez ")
        // Nuevo estudiante
        Student pablito = new Student("Pablo", "Paulo", 3);

        // Crear Nueva Escuela -> añado el estudiante a la escuela
        School salesianos = new School("Salesianos");
//        salesianos.addStudent(pablito);

        System.out.println(salesianos);
//        servicioEscuelas.addSchool(salesianos);

        servicioEscuelas.addSchoolAndFirstStudent(salesianos, pablito);
        System.out.println(servicioEscuelas.getSchoolById(2L));

        System.out.println(servicioEstudiantes.getStudentById(7L));
    }
}
