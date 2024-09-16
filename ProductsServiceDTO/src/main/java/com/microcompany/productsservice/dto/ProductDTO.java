package com.microcompany.productsservice.dto;

import com.microcompany.productsservice.constraints.SerialNumber;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@XmlRootElement
public class ProductDTO {
    @Min(0)
    private Long id;

    @Column
    @NotBlank
    @NotNull
    @Size(min = 3, max = 50)
    private String nombre;

    @Column
    @SerialNumber
    private String numSerie;
}