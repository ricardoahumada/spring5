package com.myshoppingcart.persistence.compra;

import com.myshoppingcart.config.SpringConfig;
import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import com.myshoppingcart.persistence.compra.CompraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
public class CompraRepositoryDataTest {

    Usuario currentUser;
    List<Producto> productos;

    @Autowired
    private CompraRepository repo;

    @PersistenceContext
    EntityManager em;

    @Test
    void testBeans() {
        assertThat(repo, notNullValue());
    }


    @BeforeEach
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
        System.out.println("compra:" + compra);

        Compra ncompra = repo.insertCompra(compra);

        assertThat(ncompra.getCid(), greaterThan(0));

    }

    @Test
    public void dadaCompraProductoNoValido_cuandoinsertCompra_entoncesExcepcion() throws Exception {
        Compra compra = new Compra(null, currentUser, null, LocalDate.now());
        assertThrows(Exception.class, () -> {
            Compra ncompra = repo.insertCompra(compra);
        });
    }

    @Test
    @Transactional
    public void dadaCompraProductoSinexistenciasSuficients_cuandoinsertCompra_entoncesExcepcion() throws Exception {

        Producto prod = new Producto(null, "texto1567", "marca", "util", 20, 0);

        em.persist(prod);
        em.flush();

        Compra compra = new Compra(null, currentUser, List.of(prod), LocalDate.now());

        assertThrows(Exception.class, () -> {
            Compra ncompra = repo.insertCompra(compra);
        });
    }
}
