package br.com.restaurante.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ordens")
public class Ordem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name = "valor_total")
    private Double valorToral = 0.0;
    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
    private List<OrdensCardapio> ordensCardapiosList = new ArrayList<>();

    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ordem() {
    }

    public void addOrdemCardapio(OrdensCardapio ordensCardapio) {
        ordensCardapio.setOrdem(this);
        this.ordensCardapiosList.add(ordensCardapio);
        this.valorToral += ordensCardapio.getValor() * ordensCardapio.getQuantidade();
    }

    public void setValorToral(Double valorToral) {
        this.valorToral = valorToral;
    }

    public Double getValorToral() {
        return valorToral;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getID() {
        return ID;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<OrdensCardapio> getOrdensCardapiosList() {
        return ordensCardapiosList;
    }

    public void setOrdensCardapiosList(List<OrdensCardapio> ordensCardapiosList) {
        this.ordensCardapiosList = ordensCardapiosList;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + ',' +
                " valor total: " + this.valorToral + ',' +
                " data de criação: " + this.dataDeCriacao + ',' +
                " ordem cardapio list: " + this.ordensCardapiosList + ',' +
                " cliente: " + this.cliente;
    }
}
