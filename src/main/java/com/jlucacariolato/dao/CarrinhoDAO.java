package com.jlucacariolato.dao;

import com.jlucacariolato.model.Carrinho;
import com.jlucacariolato.model.Produto;
import com.jlucacariolato.model.Tipo_Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//DAO do carrinho, necessário usar tabela associativa(carrinho_produto).

public class CarrinhoDAO {

    private Connection conn;

    //Construtor
    public CarrinhoDAO(){
        this.conn = DatabaseConnection.getConnection();
    }

    // MÉTODOS PARA MANIPULAR
    public void inserir(Carrinho carrinho){
        String sqlCarrinho = "INSERT INTO carrinho (id) VALUES (?)";
        String sqlProdutos = "INSERT INTO carrinho_produto (id_carrinho, id_produto) VALUES (?,?)";

        //Inserir carrinho
        try(PreparedStatement stmtCarrinho = conn.prepareStatement(sqlCarrinho)){
            stmtCarrinho.setInt(1,carrinho.getId());
            stmtCarrinho.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Inserir produtos
        try(PreparedStatement stmtProdutos = conn.prepareStatement(sqlProdutos)){
            //Para cada produto da lista de produtos do carrinho.
            for (Produto p : carrinho.getListaProdutos()){
                stmtProdutos.setInt(1,carrinho.getId());
                stmtProdutos.setInt(2, p.getId());
                stmtProdutos.addBatch();
            }


            stmtProdutos.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Deletar
    public void deletar(int id){
        String sqlProdutos = "DELETE FROM carrinho_produto WHERE id_carrinho = ?";
        String sqlCarrinho = "DELETE FROM carrinho WHERE id = ?";


        try (PreparedStatement stmtProdutos = conn.prepareStatement(sqlProdutos)){
            stmtProdutos.setInt(1, id);
            stmtProdutos.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement stmtCarrinho = conn.prepareStatement(sqlCarrinho)){
            stmtCarrinho.setInt(1, id);
            stmtCarrinho.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Atualizar - Deletar a tabela associativa de um carrinho_produto e inserir um novo
    public void atualizar (Carrinho carrinho){
        String sqlDelete = "DELETE FROM carrinho_produto WHERE id_carrinho = ?";
        String sqlInserir = "INSERT INTO carrinho_produto (id_carrinho, id_produto) VALUES (?, ?)";

        //Remover produto antigo
        try (PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete)){
            stmtDelete.setInt(1, carrinho.getId());
            stmtDelete.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }

        //Inserir novos produtos
        try(PreparedStatement stmtInserir = conn.prepareStatement(sqlInserir)){
            for (Produto p : carrinho.getListaProdutos()){
                stmtInserir.setInt(1, carrinho.getId());
                stmtInserir.setInt(2, p.getId());
                stmtInserir.addBatch();
            }

            stmtInserir.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
