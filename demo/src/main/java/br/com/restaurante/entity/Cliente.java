package br.com.restaurante.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @EmbeddedId
    private ClienteID clienteID;
    private String nome;

    @Embedded
    private Contato contato;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecoList = new ArrayList<>();

    public Cliente(String CPF, String email, String nome) {
        this.clienteID = new ClienteID(email, CPF);
        this.nome = nome;
    }

    public Cliente() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void addEndereco(Endereco endereco) {
        endereco.setCliente(this);
        this.enderecoList.add(endereco);
    }

    public void setCPF(String CPF) {
        clienteID.setCPF(CPF);
    }

    public String getEmail() {
        return clienteID.getEmail();
    }

        public void setEmail(String email) {
        clienteID.setEmail(email);
    }

    public String getCPF() {
        return clienteID.getCPF();
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Contato getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return "CPF: " + this.clienteID.getCPF() + ',' +
                "nome: " + this.nome + ',' +
                "contato: " + this.contato;
    }
}
