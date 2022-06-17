package com.netmind.web;

import com.netmind.domain.Coche;

public class CocheForm {
    private String marca;
    private String tipo;
    protected Integer velocidad;
    protected Float CV;
    protected boolean encendido = false;

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

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Float getCV() {
        return CV;
    }

    public void setCV(Float CV) {
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
//                velocidad != null &&
                velocidad > 0 &&
//                CV != null &&
                CV > 50
        ) return true;
        else return false;
    }

    public Coche toCoche() throws Exception{
        if (this.validate()) return new Coche(this.marca, this.tipo, this.velocidad, this.CV);
        else throw new Exception();
    }
}
