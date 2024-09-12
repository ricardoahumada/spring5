package com.microcompany.productsservice.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String serial;

    public void isValid() throws Exception {
        if (name == null || serial == null) throw new Exception("Producto no válido");
    }
}