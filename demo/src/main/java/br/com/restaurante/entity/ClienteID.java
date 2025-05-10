package br.com.restaurante.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ClienteID implements Serializable{
    private String email;
    private String CPF;

    public ClienteID(String email, String CPF) {
        this.email = email;
        this.CPF = CPF;
    }

    public ClienteID() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getCPF() {
        return CPF;
    }

    @Override
    public String toString() {
        return "ClientID{" +
                "email=" + email + '\n' +
                ", cpf=" + CPF + '\n' +
                '}';
    }
}
