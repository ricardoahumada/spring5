package com.banana.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Student.selectall",query = "SELECT s FROM Student s")
public class Student {

    public Student(Long id, String nombre, String apellido, int curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private int curso;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "escuela")
    private School school;

    @ManyToMany
    @JoinTable(
          name = "estudiantes_proyectos",
          joinColumns = {@JoinColumn(name = "estudiante")},
          inverseJoinColumns = {@JoinColumn(name = "proyecto")}
    )
    private List<Project> projects;

    public boolean isValid() {
        return this.nombre != null && this.apellido != null && this.curso > 0;
    }
}
