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

    //Método para calcular o total a pagar
    public double calcularTotalPagar() {
        if (listaProdutos == null || listaProdutos.isEmpty()) {
            return 0.0;
        }
        
        double total = 0.0;
        for (Produto produto : listaProdutos) {
            total += produto.getPreco();
        }
        this.totalPagar = total;
        return total;
    }

}
