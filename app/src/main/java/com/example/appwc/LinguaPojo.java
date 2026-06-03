package com.example.appwc;

public class LinguaPojo {

    private int id;
    private String nome;

    public LinguaPojo() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // Esse método toString é um truque bom: o ArrayAdapter usa ele para saber o que exibir na lista!
    @Override
    public String toString() {
        return this.nome;
    }
}