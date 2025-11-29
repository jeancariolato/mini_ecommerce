package com.jlucacariolato.model;

public class Checkout {
    private int id;
    private Carrinho carrinho;
    private Tipo_Pagamento tipoPagamento;

    //CONSTRUTOR
    public Checkout(int id, Carrinho carrinho, Tipo_Pagamento tipoPagamento){
        this.id = id;
        this.carrinho = carrinho;
        this.tipoPagamento = tipoPagamento;
    }

    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Tipo_Pagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Tipo_Pagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
