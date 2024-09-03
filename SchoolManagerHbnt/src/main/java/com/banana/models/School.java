package com.banana.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class School {
    private Long id;

    private String name;

    private List<Student> estudiantes = new ArrayList<>();

    public School(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addStudent(Student estudiante) {
        estudiantes.add(estudiante);
    }

    public void removeStudent(Student estudiante) {
        estudiantes.remove(estudiante);
    }

}
