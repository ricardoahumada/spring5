package com.microcompany.productsservice.model;

import com.microcompany.productsservice.constraints.SerialNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "products")
@NoArgsConstructor @AllArgsConstructor
@Data
@XmlRootElement
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    private Long id;

    @Column
    @NotBlank(message = "Debe tener valor")
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @Column
    @NotNull @NotBlank(message = "Debe tener valor con formato ddd-ddd-dddd")
    private String serial;
}
