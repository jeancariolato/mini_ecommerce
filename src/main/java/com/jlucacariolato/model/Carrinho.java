package com.jlucacariolato.model;

import java.util.List;

public class Carrinho {
    private int id;
    private List<Produto> listaProdutos;
    private double totalPagar;

    //Construtor
    public Carrinho(int id, List<Produto> listaProdutos, double totalPagar){
        this.id = id;
        this.listaProdutos = listaProdutos;
        this.totalPagar = totalPagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
