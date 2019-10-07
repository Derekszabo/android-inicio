package br.com.alura.agenda2.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {

    private String nome;
    private String tel;
    private String email;
    private int id;

    public Aluno(String nome, String tel, String email) {
        this.nome = nome;
        this.tel = tel;
        this.email = email;
    }

    public Aluno() {

    }

    public String getNome() {
        return nome;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean temIdValido() {
        return id > 0;
    }
}
