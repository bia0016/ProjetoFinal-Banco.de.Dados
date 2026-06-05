package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.Endereco;
import com.petshop.model.Pet;

public class EnderecoDAO {
    
    private Connection con;

    public EnderecoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(Endereco endereco){

        String sql = "INSERT INTO endereco(id, cep, logradouro, bairro, cidade, complemento) VALUES (?, ?, ?, ?, ?)";
    
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, endereco.getId());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getLogradouro());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getComplemento());
            ps.executeUpdate();

            System.out.println("Endereço cadastrado com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar cadastrar Endereço: " + e.getMessage());
        }
    }

    //Read - Devolve todos os Endereços

    public List<Endereco> listarEnderecos(){

        String sql = "SELECT id, cep, logradouro, bairro, cidade, complemento FROM endereco";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Endereco> enderecos = new ArrayList<>();
            while(rs.next()){
                Endereco k = new Endereco(
                    rs.getInt("id"),
                    rs.getString("cep"),
                    rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("complemento")
                );
                enderecos.add(k);
            }
            return enderecos;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Endereços: " + e.getMessage());
        }
    }

    //Read - Busca Pet pelo ID

    public Endereco buscarPorID(int id){

        String sql = "SELECT * FROM endereco WHERE id = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Endereco(

                    rs.getInt("id"),
                    rs.getString("cep"),
                    rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("complemento")
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Endereço: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados dos Pets:

    public void atualiza(Endereco endereco){

        String sql = "UPDATE endereco SET cep = ?, logradouro = ?, bairro = ?, cidade = ?, complemento = ? WHERE id = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getLogradouro());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getComplemento());
            ps.setInt(6, endereco.getId());
            ps.executeUpdate();
            System.out.println("Dados do Endereço atualizados com sucesso!");
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar dados do endereço: " + e.getMessage());
        }
    }

    //Delete - Deleta dados do Pet:

    public void apaga(int id){

        String sql = "DELETE FROM endereco WHERE id = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Dados do endereço apagados com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar apagar dados do endereço: " + e.getMessage());
        }
    }
  
}
