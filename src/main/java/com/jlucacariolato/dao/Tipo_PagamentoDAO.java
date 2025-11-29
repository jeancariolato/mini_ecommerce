package com.jlucacariolato.dao;

import com.jlucacariolato.model.Tipo_Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "DELETE * FROM tipo_pagamento WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if(rows > 0){
                System.out.println("Tipo de pagamento deletado com sucesso!");
            } else {
                System.out.println("Nenhum tipo de pagamento com esse id");
            }
        } catch (Exception e){

        }

    }

    //Atualizar tipo de pagamento
    public void atualizar(Tipo_Pagamento tipoPagamento) {
        String sql = "UPDATE tipo_pagamento SET nome = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoPagamento.getNome());
            stmt.setInt(2, tipoPagamento.getId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Nenhum produto encontrado com esse id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Listar todos os tipos de pagamento
    public List<Tipo_Pagamento> listarTodos() {
        List<Tipo_Pagamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipo_pagamento";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tipo_Pagamento t = new Tipo_Pagamento(
                        rs.getInt("id"),
                        rs.getString("nome")
                );

                lista.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
