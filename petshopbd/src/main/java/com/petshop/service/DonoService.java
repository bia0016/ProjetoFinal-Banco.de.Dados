package com.petshop.service;

import com.petshop.dao.DonoDAO;
import com.petshop.model.Dono;

public class DonoService {
    private DonoDAO DonoDAO=new DonoDAO();
    public void cadastrarDono(Dono dono) throws Exception{
        //RdN1: campos obrigatórios
        if(dono.getCpf()==null||dono.getCpf().trim().isEmpty()){
            throw new Exception("O CPF é obrigatório.");
        }
        //RdN2: tamanho do cpf
        if(dono.getCpf().length()!=11){
            throw new Exception("O CPF deve conter 11 dígitos.");
        }
        //Volta para RdN1
        if(dono.getNome()==null||dono.getNome().trim().isEmpty()){
            throw new Exception("O nome é obrigatório.");
        }
        if(dono.getTelefones()==null||dono.getTelefones().isEmpty()){
            throw new Exception("O telefone é obrigatório.");
        }
        DonoDAO.insert(dono);
    }
}
