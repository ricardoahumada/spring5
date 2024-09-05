package com.myshoppingcart.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String codigo;
    private String marca;
    private String nombre;
    private String tipo;
    private double precio;
    private int existencias;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Compra> compras;

    public Producto(Integer id, String cod, double prec) {
        this.pid = id;
        this.codigo = cod;
        this.precio = prec;
    }

    public Producto(Integer pid) {
        this.pid = pid;
    }

    public Producto(Integer pid, String codigo, String marca, String tipo, double precio, int existencias) {
        this.pid = pid;
        this.codigo = codigo;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
        this.existencias = existencias;
    }

}
