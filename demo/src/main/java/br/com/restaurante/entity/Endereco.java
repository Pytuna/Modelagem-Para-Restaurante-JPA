package br.com.restaurante.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String CEP;
    private String rua;
    private String complemento;
    private String cidade;
    private String estado;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Endereco(String CEP, String rua, String complemento, String cidade, String estado) {
        this.CEP = CEP;
        this.rua = rua;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return rua;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getID() {
        return ID;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCEP(String cEP) {
        CEP = cEP;
    }

    public String getCEP() {
        return CEP;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + ',' +
                " CEP: " + this.CEP + ',' +
                " rua: " + this.rua + ',' +
                " complemento: " + this.complemento + ',' +
                " cidade: " + this.cidade + ',' +
                " estado: " + this.estado + ',' +
                " cliente: " + this.cliente;
    }
}
