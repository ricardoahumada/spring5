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
public class Project {

    public Project(Long id, String name, List<Student> estudiantes) {
        this.id = id;
        this.name = name;
        this.estudiantes = estudiantes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "projects")
    private List<Student> estudiantes = new ArrayList<>();

//    @Column(name = "notas")
    @ElementCollection
    @OrderColumn
    private String[] notas;
}
