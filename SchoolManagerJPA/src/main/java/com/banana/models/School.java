package com.banana.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "escuela")
//    @JoinColumn(name = "escuela_id")
//    @Transient
    private List<Student> estudiantes = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address direccion;

    public School(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public School(Long id, String name, List<Student> estudiantes) {
        this.id = id;
        this.name = name;
        this.estudiantes = estudiantes;
    }

    public void addStudent(Student estudiante) {
        estudiantes.add(estudiante);
    }

    public void removeStudent(Student estudiante) {
        estudiantes.remove(estudiante);
    }

}
