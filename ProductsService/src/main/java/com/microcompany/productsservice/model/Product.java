package com.microcompany.productsservice.model;

import javax.persistence.*;
import javax.validation.constraints.*;

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

    @NotNull
    @NotEmpty
    @NotBlank(message = "Debe tener un valor")
    @Size(min = 3, max = 20, message = "Debe ser entre 3 y 20 cars")
    private String name;

    @NonNull
    @NotBlank
    @Pattern(regexp = "[1-9]{3}-[1-9]{3}-[1-9]{4}", message = "Debe tener la forma de 111-222-3333")
    private String serial;

    public void isValid() throws Exception {
        if (name == null || serial == null) throw new Exception("Producto no válido");
    }
}