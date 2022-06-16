package com.netmind.persistence;

import com.netmind.domain.Coche;

import java.util.ArrayList;
import java.util.List;

public class AlmacenCoches {
    private static List<Coche> coches = new ArrayList();

    static {
        coches.add(new Coche("Mercedes", "berlina", 200, 200));
        coches.add(new Coche("Renault", "familiar", 120, 90));
        coches.add(new Coche("Jeep", "4x4", 100, 200));
    }

    //CRUD
    public static boolean addCoche(Coche coche) {
        coches.add(coche);
        return true;
    }

    public static boolean removeCoche(Coche coche) {
        boolean resultado = true;
        if (coche == null) return false;
        else for (Coche unCoche : coches) {
            if (unCoche.getMarca().equals(coche.getMarca()) && unCoche.getTipo().equals(coche.getTipo())) {
                coches.remove(unCoche);
                break;
            }
        }

        return resultado;
    }

    public static Coche getCoche(String marca, String tipo) {
        Coche resultado = null;

        for (Coche unCoche : coches) {
            if (unCoche.getMarca().equals(marca) && unCoche.getTipo().equals(tipo)) {
                resultado = unCoche;
                break;
            }
        }

        return resultado;
    }

    public static Coche updateCoche(Coche coche) {
        Coche elCoche = getCoche(coche.getMarca(), coche.getTipo());
        if (elCoche != null) {
            elCoche.setCV(coche.getCV());
            elCoche.setVelocidad(coche.getVelocidad());
            return elCoche;
        } else {
            return null;
        }

    }

    public static List<Coche> getCoches() {
        return coches;
    }
}
