package com.banana.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Student.getStudents", query = "SELECT s FROM Student s")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "surname")
    private String apellido;

    private int curso;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id")
    @ToString.Exclude
    private School mySchool;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "estudiantes")
    @ToString.Exclude
    private Set<Project> proyectos;

    public Student(Long id, String nombre, String apellido, int curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }

    public Student(String nombre, String apellido, int curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }

    public boolean isValid() {
        return this.nombre != null && this.apellido != null && this.curso > 0;
    }
}
