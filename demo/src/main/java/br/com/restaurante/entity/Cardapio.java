package br.com.restaurante.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cardapio")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String nome;
    private String descriacao;
    private Boolean disponivel;
    private Double valor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;
    @Column(name = "data_de_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public Cardapio(String nome, String descricao, Boolean disponivel, Double valor, Categoria categoria) {
        this.nome = nome;
        this.descriacao = descricao;
        this.disponivel = disponivel;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Cardapio() {}
 
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descriacao;
    }

    public void setDescricao(String descricao) {
        this.descriacao = descricao;
    }

    public Boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Double getPreco() {
        return this.valor;
    }

    public void setPreco(Double preco) {
        this.valor = preco;
    }

    public LocalDateTime getData() {
        return this.dataRegistro;
    }

    public void setData(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void serCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ',' +
                " Descriacao: " + this.descriacao + ',' +
                " Disponivel: " + this.disponivel + ',' +
                " Preço: " + this.valor + ',' + 
                " Categoria: " + this.categoria;
    }
}
