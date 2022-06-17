package com.netmind.domain;

public class Coche {
    private String marca;
    private String tipo;
    protected int velocidad;
    protected float CV;
    protected boolean encendido = false;

    public Coche(String marca, String tipo, int velocidad, float CV) {
        //validaciones
        this.marca = marca;
        this.tipo = tipo;
        this.velocidad = velocidad;
        this.CV = CV;
    }

    public boolean frenarDeGolpe() {
        return true;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public float getCV() {
        return CV;
    }

    public void setCV(float CV) {
        this.CV = CV;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'' +
                ", velocidad=" + velocidad +
                ", CV=" + CV +
                ", encendido=" + encendido +
                '}';
    }

    public boolean validate() {
        if (marca != null &&
                marca.length() > 3 &&
                tipo != null &&
                tipo.length() > 3 &&
                velocidad > 0 &&
                CV > 50
        )
            return true;
        else return false;
    }
}
