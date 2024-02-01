package com.banana.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private Long id;
    private String nombre;
    private String apellido;
    private int curso;

    public boolean isValid() {
        return this.nombre != null && this.apellido != null && this.curso > 0;
    }
}
