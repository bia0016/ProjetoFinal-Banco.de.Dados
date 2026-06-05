package com.petshop.service;

import com.petshop.dao.PetDAO;
import com.petshop.model.Pet;

public class PetService {
    private PetDAO PetDAO=new PetDAO();
    public void cadastrarPet(Pet pet) throws Exception{
        if(pet.getNome()==null||pet.getNome().trim().isEmpty()){
            throw new Exception("O nome é obrigatório.");
        }
        if(pet.getEspecie()==null||pet.getEspecie().trim().isEmpty()){
            throw new Exception("Por favor, informe a espécie.");
        }
        if(pet.getDono()==null){
            throw new Exception("Informe um usuário cadastrado.");
        }
        if(pet.getDono().getCpf()==null||pet.getDono().getCpf().trim().isEmpty()){
            throw new Exception("O CPF é obrigatório.");
        }
        PetDAO.insert(pet);
    }
}
