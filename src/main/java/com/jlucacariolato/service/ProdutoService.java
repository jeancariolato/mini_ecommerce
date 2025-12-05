package com.jlucacariolato.service;

import com.jlucacariolato.dao.ProdutoDAO;
import com.jlucacariolato.model.Produto;

public class ProdutoService {

    //CARREGA A DAO
    ProdutoDAO produtoDAO = new ProdutoDAO();

    //MÉTODOS DE MANIPULAÇÃO
    public void inserir(Produto produto){
        produtoDAO.salvar(produto);
    }

    public void deletar(int id){
        produtoDAO.deletar(id);
    }

    public void atualizar (Produto produto){
        produtoDAO.atualizar(produto);
    }

    public void listar(){
        produtoDAO.listarTodos();
    }



}
