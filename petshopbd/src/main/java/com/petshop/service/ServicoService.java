package com.petshop.service;

import com.petshop.dao.ServicoDAO;
import com.petshop.model.Servico;

public class ServicoService {
    private ServicoDAO ServicoDAO=new ServicoDAO();
    public void cadastrarServico(Servico servico) throws Exception{
        if(servico.getTipo()==null){
            throw new Exception("Selecione um tipo válido.");
        }
        if(servico.getPreco()<=0){
            throw new Exception("O preço deve ser maior que R$0,00.");
        }
        ServicoDAO.insert(servico);
    }
}
