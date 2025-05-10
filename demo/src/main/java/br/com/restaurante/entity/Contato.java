package br.com.restaurante.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Contato {
    private String DDD;
    private String numero;

    public Contato(String DDD, String numero) {
        this.DDD = DDD;
        this.numero = numero;
    }

    public Contato() {
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setDDD(String dDD) {
        DDD = dDD;
    }

    public String getDDD() {
        return DDD;
    }

    @Override
    public String toString() {
        return "DDD: " + this.DDD + ',' +
                " número: " + this.numero;
    }
}
