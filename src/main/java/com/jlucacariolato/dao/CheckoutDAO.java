package com.jlucacariolato.dao;

import com.jlucacariolato.model.Carrinho;
import com.jlucacariolato.model.Checkout;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CheckoutDAO {

    private Connection conn;


    //Consturtor
    public CheckoutDAO() {
        this.conn = DatabaseConnection.getConnection();
    }

    //MÉTODOS PARA MANIPULAR
    public void deletar(int id) {
        String sql = "DELETE FROM checkout WHERE id = ?";
    }

    public void inserir(Checkout checkout){
        String sql = "INSERT INTO checkout (carrinho_id, tipo_pagamento_id, valor_total) VALUES (?,?,?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, checkout.getId());
            stmt.setInt(2, checkout.getId_tipo_pagamento());
            stmt.setDouble(3, checkout.getValortotal());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
