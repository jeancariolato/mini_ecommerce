package com.jlucacariolato.service;

import com.jlucacariolato.dao.CarrinhoDAO;
import com.jlucacariolato.model.Carrinho;

public class CarrinhoService {

    //CARREGA DAO
    CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

    // METODOS
    public void inserir(Carrinho carrinho){
        carrinhoDAO.inserir(carrinho);
    }

    public void deletar(int id){
        carrinhoDAO.deletar(id);
    }

    public void atualizar(Carrinho carrinho){
        carrinhoDAO.atualizar(carrinho);
    }
}
