package br.com.restaurante.vo;

public class ItensPrincipaisVO {
    private String nome;
    private Long quatidade;

    public ItensPrincipaisVO(String nome, Long quantidade) {
        this.nome = nome;
        this.quatidade = quantidade;
    }

    public ItensPrincipaisVO() {
    }

    public void setQuatidade(Long quatidade) {
        this.quatidade = quatidade;
    }

    public Long getQuatidade() {
        return quatidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ',' +
                " quantidade: " + this.quatidade;
    }
}