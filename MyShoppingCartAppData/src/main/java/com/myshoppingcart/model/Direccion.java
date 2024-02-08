package com.myshoppingcart.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;
    private String direccionCompleta;

//    @OneToOne(mappedBy = "direccion")
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Direccion(Long did, String direccionCompleta) {
        this.did = did;
        this.direccionCompleta = direccionCompleta;
    }
}
