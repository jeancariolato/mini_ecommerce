package com.jlucacariolato.model;

public class Tipo_Pagamento {
    private int id;
    private String nome;

    //Construtor
    public Tipo_Pagamento(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
