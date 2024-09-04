package com.banana.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class School {
    private Long id;

    private String name;

    public School(Long id, String name, List<Student> estudantes) {
        this.id = id;
        this.name = name;
    }

    /*public void addStudent(Student estudiante) {
        estudiantes.add(estudiante);
    }*/

    /*public void removeStudent(Student estudiante) {
        estudiantes.remove(estudiante);
    }*/

}
