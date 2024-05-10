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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "project_student",
            joinColumns = {@JoinColumn(name = "estudiante")},
            inverseJoinColumns = {@JoinColumn(name = "proyecto")}
    )
    private List<Student> estudiantes = new ArrayList<>();
}
