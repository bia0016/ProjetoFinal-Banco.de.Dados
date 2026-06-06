package com.petshop.service;

import com.petshop.dao.ComandaDAO;
import com.petshop.dao.RegistroServicoDAO;
import com.petshop.model.Comanda;

public class ComandaService {

    private ComandaDAO comandaDAO = new ComandaDAO();

    public void cadastrarComanda(Comanda comanda) throws Exception {

        if(comanda.getPrecoTotal() <= 0){
            throw new Exception("Erro ao tentar cadastrar comanda: o preço total deve ser maior que R$0,00.");
        }

        if(comanda.getIdRegistro() == null){
            throw new Exception("Erro: a comanda precisa estar vinculada a um registro de serviço.");
        }

        RegistroServicoDAO regDAO = new RegistroServicoDAO();
        if(regDAO.buscarPorId(comanda.getIdRegistro()) == null){
            throw new Exception("Erro ao tentar cadastrar comanda: registro de serviço não encontrado.");
        }

        if(comanda.getMetodoPagamento() == null){
            throw new Exception("Erro ao tentar cadastrar comanda: informe um método de pagamento.");
        }

        comandaDAO.insert(comanda);
    }

    public void atualizarComanda(Comanda comanda) throws Exception {

        if(comandaDAO.buscarPorID(comanda.getIdComanda()) == null){
            throw new Exception("Erro ao tentar atualizar comanda: comanda não encontrada.");
        }

        if(comanda.getPrecoTotal() <= 0){
            throw new Exception("Erro: o preço total deve ser maior que R$0,00.");
        }

        // Valida o método de pagamento
        if(comanda.getMetodoPagamento() == null){
            throw new Exception("Erro: informe um método de pagamento.");
        }

        comandaDAO.atualiza(comanda);
    }

    public void deletarComanda(int idComanda) throws Exception {

        if(comandaDAO.buscarPorID(idComanda) == null){
            throw new Exception("Erro ao tentar apagar comanda: comanda não encontrada.");
        }

        comandaDAO.apaga(idComanda);
    }
}
