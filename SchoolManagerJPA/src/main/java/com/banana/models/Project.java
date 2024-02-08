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
@Inheritance(strategy = InheritanceType.JOINED)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "project_student",
            joinColumns = {@JoinColumn(name = "projecto_id")},
            inverseJoinColumns= {@JoinColumn(name = "estudiante_id")}
    )
    private List<Student> estudiantes = new ArrayList<>();
}
