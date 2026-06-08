package com.petshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.Dono;
import com.petshop.model.Endereco;


public class DonoDAO {
    

    // Toda vez que criar o DAO, ele conecta com o BD e guarda no "con":
    private Connection con;

    public DonoDAO(){

        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(Dono dono){
        
        String sql = "INSERT INTO DONO (CPF, NOME, EMAIL, ID_ENDERECO) VALUES (?, ?, ?, ?)";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dono.getCpf());
            ps.setString(2, dono.getNome());
            ps.setString(3, dono.getEmail());
            ps.setInt(4, dono.getEndereco().getId());
            ps.executeUpdate();

            System.out.println("Cadastro de dono feito com sucesso!");
            
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao tentar cadastrar dono: " + e.getMessage()); 
        }

    }

    //Read - Devolve todos os Donos

    public List<Dono> listarDonos(){

        String sql = "SELECT CPF, NOME, EMAIL FROM DONO";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Dono> donos = new ArrayList<>();
            while(rs.next()){
                Dono k = new Dono(
                    rs.getString("CPF"),
                    rs.getString("NOME"),
                    rs.getString("EMAIL"),
                    null,
                    null,
                    null
                );
                donos.add(k);
            }
            return donos;
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao listar donos: " + e.getMessage());
        }
    }

    //Read - Devolve um Dono pelo CPF

    public Dono buscarPorCPF(String cpf){

        String sql = "SELECT D.CPF, D.NOME, D.EMAIL, " +
             "E.ID_ENDERECO, E.CEP, E.LOGRADOURO, E.BAIRRO, E.CIDADE, E.COMPLEMENTO " +
             "FROM DONO D " +
             "LEFT JOIN ENDERECO E ON D.ID_ENDERECO = E.ID_ENDERECO " +
             "WHERE D.CPF = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){

                Endereco endereco = new Endereco(
                    rs.getInt("ID_ENDERECO"),
                    rs.getString("CEP"),
                    rs.getString("LOGRADOURO"),
                    rs.getString("BAIRRO"),
                    rs.getString("CIDADE"),
                    rs.getString("COMPLEMENTO")
                );

                return new Dono(
                    rs.getString("CPF"),
                    rs.getString("NOME"),
                    rs.getString("EMAIL"),
                    endereco,
                    null,
                    null
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar dono: " + e.getMessage());
        }

        return null;
    } 

    //Update - Atualiza dados dos donos

    public void atualiza(Dono dono){

        String sql = "UPDATE DONO SET NOME = ?, EMAIL = ? WHERE CPF = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dono.getNome());
            ps.setString(2, dono.getEmail());
            ps.setString(3, dono.getCpf());
            ps.executeUpdate();
            System.out.println("Dados de dono atualizados com sucesso!");
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar dados: " + e.getMessage());
        }

    }

    //Delete - Apaga os dados de um dono:

    public void apagar(Dono dono){

        String sql = "DELETE FROM DONO WHERE CPF = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dono.getCpf());
            ps.executeUpdate();
            System.out.println("Dono removido com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar apagar dono: " + e.getMessage());
        }
    }
}
