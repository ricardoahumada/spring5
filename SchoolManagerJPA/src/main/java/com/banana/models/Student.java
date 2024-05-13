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
@NamedQuery(name = "Student.findByIdx", query = "SELECT s FROM Student s WHERE s.nombre = :nombre ORDER BY s.id ASC")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "surname")
    private String apellido;


    private int curso;

    public Student(Long id, String nombre, String apellido, int curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }

    public Student(Long id, String nombre, String apellido, int curso, School escuela) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.escuela = escuela;
    }

    @OneToOne
    @JoinColumn
    private Address address;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "escuela")
    private School escuela;


    @ManyToMany(mappedBy = "estudiantes")
    private Set<Project> proyectos;

    public boolean isValid() {
        return this.nombre != null && this.apellido != null && this.curso > 0;
    }
}
