package com.netmind.web;

import com.netmind.domain.Coche;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CochesControllerTest {

    @Test
    public void get_lista_MV() {
        CochesController cc = new CochesController();
        ModelAndView mav = cc.get_lista_MV();
        Map datos = mav.getModel();
        List<Coche> coches = (List<Coche>) datos.get("coches");
        assertTrue(coches.size() > 0);
        Coche primerCoche = coches.get(0);
        assertTrue(primerCoche.getMarca().equals("Mercedes"));
    }

    @Test
    public void get_coche_query_mav_positivo() {
        CochesController cc = new CochesController();
        String marca = "Mercedes", tipo = "berlina";
        ModelAndView mav = cc.get_coche_query_mav(marca, tipo);
        Map datos = mav.getModel();
        System.out.println(datos);
        Coche elCoche = (Coche) datos.get("elCoche");
        assertTrue(elCoche != null);
        assertTrue(elCoche.getMarca().equals(marca) && elCoche.getTipo().equals(tipo));
    }

    @Test
    public void get_coche_query_mav_negativo() {
        CochesController cc = new CochesController();
        String marca = "Fiat", tipo = "berlina";
        ModelAndView mav = cc.get_coche_query_mav(marca, tipo);
        Map datos = mav.getModel();
        System.out.println(datos);
        Coche elCoche = (Coche) datos.get("elCoche");
        assertNull(elCoche);
    }
}