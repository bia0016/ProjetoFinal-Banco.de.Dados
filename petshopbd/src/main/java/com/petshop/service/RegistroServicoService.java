package com.petshop.service;

import java.time.LocalDate;

import com.petshop.dao.RegistroServicoDAO;
import com.petshop.model.RegistroServico;

public class RegistroServicoService {
    private RegistroServicoDAO regServDAO=new RegistroServicoDAO();
    public void cadastrarRegistroServico(RegistroServico regServ) throws Exception{
        if(regServ.getServico()==null){
            throw new Exception("Informe o serviço para o registro.");
        }
        if(regServ.getDono()==null){
            throw new Exception("Informe um usuário cadastrado.");
        }
        if(regServ.getIdPet()==null){
            throw new Exception("Informe um pet cadastrado.");
        }
        if(regServ.getData()==null){
            throw new Exception("Informe uma data.");
        }
        if(LocalDate.parse(regServ.getData()).isBefore(LocalDate.now())){
            throw new Exception("Não é possível salvar nesta. Por favor, tente outra.");
        }
        regServDAO.insert(regServ);
    }
}
