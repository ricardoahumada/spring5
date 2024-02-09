package com.myshoppingcart.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Transient
    private Usuario usuario;

    @Transient
    private List<Producto> productos;

    private LocalDate fecha;

    public double calcTotal() {
        double total = 0.0;
        if (productos != null) {
            for (Producto producto : productos) {
                total += producto.getPrecio();
            }
        }

        return total;
    }

    public boolean isValid() throws Exception {
        if (usuario.getUid() > 0 && productos.size() > 0) return true;
        else {
            throw new RuntimeException("Compra no valida");
        }
    }
}
