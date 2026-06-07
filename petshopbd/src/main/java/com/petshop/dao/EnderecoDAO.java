package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.Endereco;

public class EnderecoDAO {
    
    private Connection con;

    public EnderecoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(Endereco endereco){

        String sql = "INSERT INTO ENDERECO (CEP, LOGRADOURO, BAIRRO, CIDADE, COMPLEMENTO) VALUES (?, ?, ?, ?, ?)";
    
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getLogradouro());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getComplemento());
            ps.executeUpdate();

            System.out.println("Endereço cadastrado com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar cadastrar Endereço: " + e.getMessage());
        }
    }

    //Read - Devolve todos os Endereços

    public List<Endereco> listarEnderecos(){

        String sql = "SELECT ID_ENDERECO, CEP, LOGRADOURO, BAIRRO, CIDADE, COMPLEMENTO FROM ENDERECO";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Endereco> enderecos = new ArrayList<>();
            while(rs.next()){
                Endereco k = new Endereco(
                    rs.getInt("ID_ENDERECO"),
                    rs.getString("CEP"),
                    rs.getString("LOGRADOURO"),
                    rs.getString("BAIRRO"),
                    rs.getString("CIDADE"),
                    rs.getString("COMPLEMENTO")
                );
                enderecos.add(k);
            }
            return enderecos;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Endereços: " + e.getMessage());
        }
    }

    //Read - Busca Endereço pelo ID

    public Endereco buscarPorID(int id){

        String sql = "SELECT ID_ENDERECO, CEP, LOGRADOURO, BAIRRO, CIDADE, COMPLEMENTO FROM ENDERECO WHERE ID_ENDERECO = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Endereco(
                    rs.getInt("ID_ENDERECO"),
                    rs.getString("CEP"),
                    rs.getString("LOGRADOURO"),
                    rs.getString("BAIRRO"),
                    rs.getString("CIDADE"),
                    rs.getString("COMPLEMENTO")
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Endereço: " + e.getMessage());
        }
        return null;
    }

    //Read - Busca Endereço pelo CEP

    public Endereco buscarPorCEP(String cep){

        String sql = "SELECT ID_ENDERECO, CEP, LOGRADOURO, BAIRRO, CIDADE, COMPLEMENTO FROM ENDERECO WHERE CEP = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cep);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Endereco(
                    rs.getInt("ID_ENDERECO"),
                    rs.getString("CEP"),
                    rs.getString("LOGRADOURO"),
                    rs.getString("BAIRRO"),
                    rs.getString("CIDADE"),
                    rs.getString("COMPLEMENTO")
                );

            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao tentar buscar endereço: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados do Endereço

    public void atualiza(Endereco endereco){

        String sql = "UPDATE ENDERECO SET CEP = ?, LOGRADOURO = ?, BAIRRO = ?, CIDADE = ?, COMPLEMENTO = ? WHERE ID_ENDERECO = ?";

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

    //Delete - Deleta dados do Endereço

    public void apaga(int id){

        String sql = "DELETE FROM ENDERECO WHERE ID_ENDERECO = ?";

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
