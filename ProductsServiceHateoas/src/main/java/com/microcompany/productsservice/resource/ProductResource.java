package com.microcompany.productsservice.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microcompany.productsservice.constraints.SerialNumber;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@XmlRootElement
public class ProductResource extends RepresentationModel<ProductResource> {
    @Min(0)
    private Long id;

    @NotBlank(message = "Debe tener valor")
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @NotBlank(message = "Debe tener valor con formato ddd-ddd-dddd")
    @SerialNumber(message = "{serial.format}")
    private String serial;
}
