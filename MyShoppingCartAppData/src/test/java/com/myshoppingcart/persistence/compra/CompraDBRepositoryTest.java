package com.myshoppingcart.persistence.compra;

import com.myshoppingcart.config.SpringConfig;
import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import com.myshoppingcart.persistence.compra.ICompraRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class CompraDBRepositoryTest {

    Usuario currentUser;
    List<Producto> productos;

    @Autowired
    private ICompraRepository repo;

    @Test
    void testBeans() {
        assertThat(repo, notNullValue());
    }


    void setUp() {
        this.currentUser = new Usuario(1);
        this.productos = List.of(
                new Producto(1),
                new Producto(2)
        );


    }

    @Test
    public void dadaCompraValida_cuandoinsertCompra_entoncesOK() throws Exception {
        Compra compra = new Compra(null, currentUser, productos, LocalDate.now());

        Compra ncompra = repo.insertCompra(compra);

        assertThat(ncompra.getCid(), greaterThan(1));

    }

    @Test
    public void dadaCompraProductoNoValido_cuandoinsertCompra_entoncesExcepcion() throws Exception {
        Compra compra = new Compra(null, currentUser, null, LocalDate.now());
        assertThrows(Exception.class, () -> {
            Compra ncompra = repo.insertCompra(compra);
        });
    }

    @Test
    public void dadaCompraProductoSinexistenciasSuficients_cuandoinsertCompra_entoncesExcepcion() throws Exception {

        List<Producto> demasiadosProductos = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            demasiadosProductos.add(new Producto(1));
        }
        Compra compra = new Compra(null, currentUser, demasiadosProductos, LocalDate.now());
        assertThrows(Exception.class, () -> {
            Compra ncompra = repo.insertCompra(compra);
        });
    }
}
