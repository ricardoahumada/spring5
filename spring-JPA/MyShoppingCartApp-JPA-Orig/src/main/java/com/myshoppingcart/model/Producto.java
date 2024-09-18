package com.myshoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Producto {

    private Integer mid;
    private String codigo;
    private String marca;
    private String tipo;
    private double precio;
    private int existencias;

    public Producto(Integer id, String cod, double prec) {
        this.mid = id;
        this.codigo = cod;
        this.precio = prec;
    }

}
