package br.com.restaurante.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ordens_Cardapio")
public class OrdensCardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ordem ordem;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cardapio cardapio;
    @Column(name = "Valor_de_Registro")
    private Double valorDeRegistro;
    private Integer quantidade;

    public OrdensCardapio(Cardapio cardapio, Integer quantidade) {
        this.quantidade = quantidade;
        this.cardapio = cardapio;
        this.valorDeRegistro = cardapio.getPreco();
    }

    public OrdensCardapio() {
    }

    public void setValor(Double valor) {
        this.valorDeRegistro = valor;
    }

    public Double getValor() {
        return valorDeRegistro;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getID() {
        return ID;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + ',' +
                " cardapio: " + this.cardapio + ',' +
                " valor de registro: " + this.valorDeRegistro + ',' +
                " quantidade: " + this.quantidade;
    }
}
