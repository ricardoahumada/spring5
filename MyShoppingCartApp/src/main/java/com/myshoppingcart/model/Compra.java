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

    /*
    // unidirecciona compra-usuario
    @ManyToOne()
    @JoinColumn(name = "user_id")*/
    //bidireccional compra - usuario
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "compra_productos",
            joinColumns = {@JoinColumn(name = "compra_id")},
            inverseJoinColumns = {@JoinColumn(name = "producto_id")}
    )
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
