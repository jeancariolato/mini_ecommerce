package com.jlucacariolato.dao;

import com.jlucacariolato.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection conn;

    //CONSTRUTOR
    // puxando a conexão
    public ProdutoDAO() {
        this.conn = DatabaseConnection.getConnection();
    }

    //Métodos para manipular no database SQL

    //Salvar produto
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Listar todos os produtos
    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco")
                );

                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Atualizar produtos
    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getId());

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


    // Deletar produto
    public void deletar(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);

            int rows = stmt.executeUpdate();

            if(rows > 0){
                System.out.println("Produto deletado com sucesso!");
            } else {
                System.out.println("Nenhum produto com esse id");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
