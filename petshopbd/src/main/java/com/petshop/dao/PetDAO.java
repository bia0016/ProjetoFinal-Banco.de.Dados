package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.Pet;

public class PetDAO {
    
    private Connection con;

    public PetDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(Pet pet){

        String sql = "INSERT INTO pet(nome, especie, raca, porte) VALUES (?, ?, ?, ?, ?)";
    
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, pet.getNome());
            ps.setString(3, pet.getEspecie());
            ps.setString(4, pet.getRaca());
            ps.setString(5, pet.getPorte());
            ps.executeUpdate();

            System.out.println("Pet cadastrado com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar cadastrar pet: " + e.getMessage());
        }
    }

    //Read - Devolve todos os Pet

    public List<Pet> listarPets(){

        String sql = "SELECT idPet, nome, especie, raca, porte FROM pet";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Pet> pets = new ArrayList<>();
            while(rs.next()){
                Pet k = new Pet(
                    rs.getInt("idPet"),
                    rs.getString("nome"),
                    rs.getString("especie"),
                    rs.getString("raca"),
                    rs.getString("porte")
                );
                pets.add(k);
            }
            return pets;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Pets: " + e.getMessage());
        }
    }

    //Read - Busca Pet pelo ID

    public Pet buscarPorID(int idPet){

        String sql = "SELECT * FROM pet WHERE idPet = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPet);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Pet(

                    rs.getInt("idPet"),
                    rs.getString("nome"),
                    rs.getString("especie"),
                    rs.getString("raca"),
                    rs.getString("porte")
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Pet: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados dos Pets:

    public void atualiza(Pet pet){

        String sql = "UPDATE pet SET nome = ?, especie = ?, raca = ?, porte = ? WHERE idPet = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pet.getNome());
            ps.setString(2, pet.getEspecie());
            ps.setString(3, pet.getRaca());
            ps.setString(4, pet.getPorte());
            ps.setInt(5, pet.getIdPet());
            ps.executeUpdate();
            System.out.println("Dados de Pet atualizados com sucesso!");
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar dados do Pet: " + e.getMessage());
        }
    }

    //Delete - Deleta dados do Pet:

    public void apaga(int idPet){

        String sql = "DELETE FROM pet WHERE idPet = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPet);
            ps.executeUpdate();
            System.out.println("Dados do Pet apagados com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar apagar dados do Pet: " + e.getMessage());
        }
    }

}