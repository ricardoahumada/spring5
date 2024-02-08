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
@NamedQuery(name = "Student.get", query = "SELECT e FROM Student e WHERE e.nombre = ?1")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "surname")
    private String apellido;

    private int curso;

    @ManyToOne
    @JoinColumn(name = "escuela_id")
    private School escuela;

    @ManyToMany(mappedBy = "estudiantes")
    private Set<Project> proyectos;

    public Student(Long id, String nombre, String apellido, int curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }

    public boolean isValid() {
        return this.nombre != null && this.apellido != null && this.curso > 0;
    }
}
