package com.developer.allef.gestaocontrol.Model;

/**
 * Created by Allef on 18/02/2017.
 */

public class Usuario {

    private long codigo;
    private String nome;
    private String email;

    public Usuario() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
