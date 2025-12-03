package com.jlucacariolato.model;

import java.time.LocalDateTime;

public class Checkout {
    private int id;
    private int id_carrinho;
    private int id_tipo_pagamento;
    private double valortotal;
    private LocalDateTime dataCheckout;

    //CONSTRUTOR

    public Checkout(){

    }

    public Checkout(int id, int id_carrinho, int id_tipo_pagamento) {
        this.id = id;
        this.id_carrinho = id_carrinho;
        this.id_tipo_pagamento = id_tipo_pagamento;
    }


    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(int id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public int getId_tipo_pagamento() {
        return id_tipo_pagamento;
    }

    public void setId_tipo_pagamento(int id_tipo_pagamento) {
        this.id_tipo_pagamento = id_tipo_pagamento;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public LocalDateTime getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(LocalDateTime dataCheckout) {
        this.dataCheckout = dataCheckout;
    }
}
