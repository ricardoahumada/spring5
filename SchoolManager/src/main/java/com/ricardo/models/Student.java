package com.ricardo.models;

public class Student {
    private Long id;
    private String nombre;
    private String apellido;
    private int curso;

    public Student() {
    }

    public Student(Long id, String nombre, String apellido, int curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }
    public Student(String nombre, String apellido, int curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", curso=" + curso +
                '}';
    }


    public boolean isValid() {
        if (this.nombre != null && this.apellido != null && this.curso > 0) return true;
        else return false;
    }
}
