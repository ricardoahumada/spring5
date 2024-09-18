package com.microcompany.productsservice.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.microcompany.productsservice.constraints.SerialNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(name = "Modelo de producto", description = "Representa un producto a intercambiar")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Id", description = "El identificador único del producto. Debe ser un número mayor que 0. No es requerido en POST y PUT", required = false, example = "234")
    private Long id;

//    @NotNull
    @NotEmpty
    @NotBlank(message = "Debe tener un valor")
    @Size(min = 3, max = 20)
    private String name;

//    @NonNull
    @NotBlank
//    @Pattern(regexp = "[1-9]{3}-[1-9]{3}-[1-9]{4}", message = "Debe tener la forma de 111-222-3333")
    @SerialNumber(message = "{serial.format}")
    private String serial;

    public void isValid() throws Exception {
        if (name == null || serial == null) throw new Exception("Producto no válido");
    }


}