package com.jlucacariolato.dao;

import com.jlucacariolato.model.Produto;
import com.jlucacariolato.model.Tipo_Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tipo_PagamentoDAO {

    private Connection conn;

    //Construtor

    //Puxar conexão com DB
    public Tipo_PagamentoDAO() {
        this.conn = DatabaseConnection.getConnection();
    }

    //Métodos para manipular

    //Salvar tipo de pagamento
    public void salvar(Tipo_Pagamento tipoPagamento) {
        String sql = "INSERT INTO tipo_pagamento (nome) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoPagamento.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Deletar tipo de pagamento
    public void deletar(int id) {
        String sql = "";

    }
}
