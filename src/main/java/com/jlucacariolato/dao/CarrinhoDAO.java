package com.jlucacariolato.dao;

import com.jlucacariolato.model.Carrinho;
import com.jlucacariolato.model.Tipo_Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//45rr
public class CarrinhoDAO {

    private Connection conn;

    //Construtor
    public CarrinhoDAO(){
        this.conn = DatabaseConnection.getConnection();
    }

    // Métodos
    public void inserir(Carrinho carrinho){
        String sqlCarrinho = "INSERT INTO carrinho (id) VALUES (?)";
        String sqlProdutos = "INSERT INTO carrinho_produto (id_carrinho, id_produto) VALUES (?,?)";

    }



}
