package com.ricardo.models;

import java.util.ArrayList;
import java.util.List;

public class School {
    private Long id;
    private String name;
    private List<Student> estudiantes = new ArrayList<>();

    public School() {
    }

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Student> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", estudiantes=" + estudiantes +
                '}';
    }
}
