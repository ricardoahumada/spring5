package com.netmind.web;

public class FormBean {
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "FormBean{" +
                "valor='" + valor + '\'' +
                '}';
    }
}
