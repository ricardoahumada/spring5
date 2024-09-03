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
public class Compra {
    private Integer cid;
    private int usuario;
    private int producto;
    private int cantidad;
    private LocalDate fecha;
}
