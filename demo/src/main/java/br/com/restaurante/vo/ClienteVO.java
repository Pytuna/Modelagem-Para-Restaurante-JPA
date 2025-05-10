package br.com.restaurante.vo;

public class ClienteVO {
    private String CPF;
    private String nome;

    public ClienteVO(String CPF, String nome) {
        this.CPF = CPF;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getCPF() {
        return CPF;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ',' +
                " CPF: " + this.CPF;
    }
}
