package com.jlucacariolato.service;

import com.jlucacariolato.dao.Tipo_PagamentoDAO;
import com.jlucacariolato.model.Tipo_Pagamento;

public class TipoPagamentoService {

    //CARREGA DAO
    Tipo_PagamentoDAO tipoPagamentoDAO = new Tipo_PagamentoDAO();

    //METODOS DE MANIPULACAO
    public void inserir(Tipo_Pagamento tipoPagamento) {
        tipoPagamentoDAO.salvar(tipoPagamento);
    }

    public void atualizar(Tipo_Pagamento tipoPagamento) {
        tipoPagamentoDAO.atualizar(tipoPagamento);
    }

    public void deletar(int id) {
        tipoPagamentoDAO.deletar(id);
    }

    public void listar(){
        tipoPagamentoDAO.listarTodos();
    }



}
