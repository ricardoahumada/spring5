package com.myshoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Usuario {
    private Integer uid;
    private String nombre;
    private String apellido;
    private String email;
    private int interes;
    private double saldo;
    private String password;
    private LocalDate nacimiento;
    private boolean activo;

}
