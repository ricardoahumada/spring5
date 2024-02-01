package com.myshoppingcart.service;

import com.myshoppingcart.config.SpringConfig;
import com.myshoppingcart.model.Producto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class ShoppingCartTest {

    @Autowired
    IShoppingCart cart;

    @Test
    void testBeans() {
        assertThat(cart, notNullValue());
    }


    @Test
    void cuando_se_crea_el_carrito_tiene_0_artículos() throws Exception {
        // given ... void

        // when

        // then
        int num = cart.getItemCount();
        double bal = cart.getBalance();

        assertThat(num, is(0));
        assertThat(bal, is(0d));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10, 1000})
    void cuando_está_vacío_el_carrito_tiene_0_artículos(int numProducts) throws Exception {
        // given

        Random rand = new Random();

        for (int i = 0; i < numProducts; i++) {
            cart.addItem(new Producto(i + 1, "fake " + i, rand.nextDouble() * 100));
        }

        // System.out.println("count: " + cart.getItemCount());

        // when
        cart.empty();

        // then
        int num = cart.getItemCount();
        double bal = cart.getBalance();

        assertThat(num, is(0));
        assertThat(bal, is(0d));
    }

    @Test
    void cuando_se_agrega_un_nuevo_producto_la_cantidad_de_artículos_debe_ser_incrementado() {

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10, 1000})
    void cuando_se_agrega_un_nuevo_producto_el_nuevo_saldo_debe_ser_la_suma_de_anteriores_más_el_costo_del_producto(int numProducts) throws Exception {
        // given
        Random rand = new Random();
        double inc = 0;

        // when
        for (int i = 0; i < numProducts; i++) {
            double precio = rand.nextDouble() * 100;
            cart.addItem(new Producto(i + 1, "fake " + i, precio));
            inc += precio;
        }

        System.out.println("count: " + cart.getItemCount());

        // then
        int num = cart.getItemCount();
        double bal = cart.getBalance();

        assertThat(num, is(numProducts));
        assertThat(bal, is(inc));
    }

    @Test
    void cuando_se_elimina_un_elemento_se_debe_disminuir_el_número_de_elementos() {

    }

    @Test
    void cuando_se_retira_un_producto_que_no_está_en_el_carrito_se_debe_lanzar_ProductNotFoundException() {

    }

    @Test
    void dadoCarritoNoVacio_cuandoComprar_entoncesOK() throws Exception {

        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            cart.addItem(new Producto(i + 1, "fake " + i, rand.nextDouble() * 100));
        }

        cart.comprar();

        assertTrue(true);

    }
}