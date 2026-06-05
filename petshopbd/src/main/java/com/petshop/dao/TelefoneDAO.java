package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.Telefone;

public class TelefoneDAO {
    
    private Connection con;

    public TelefoneDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(Telefone telefone){

        String sql = "INSERT INTO telefone(idTel, ddd, numero, descricao) VALUES (?, ?, ?, ?, ?)";
    
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, telefone.getIdTel());
            ps.setString(2, telefone.getDdd());
            ps.setString(3, telefone.getNumero());
            ps.setString(4, telefone.getDescricao());
            ps.executeUpdate();

            System.out.println("Telefone cadastrado com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar cadastrar telefone: " + e.getMessage());
        }
    }

    //Read - Devolve todos os Endereços

    public List<Telefone> listarTelefone(){

        String sql = "SELECT idTel, ddd, numero, descricao FROM telefone";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Telefone> telefones = new ArrayList<>();
            while(rs.next()){
                Telefone k = new Telefone(
                    rs.getInt("idTel"),
                    rs.getString("ddd"),
                    rs.getString("numero"),
                    rs.getString("descricao")
                );
                telefones.add(k);
            }
            return telefones;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Telefones: " + e.getMessage());
        }
    }

    //Read - Busca Pet pelo ID

    public Telefone buscarPorID(int idTel){

        String sql = "SELECT * FROM telefone WHERE idTel = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTel);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Telefone(

                    rs.getInt("idTel"),
                    rs.getString("ddd"),
                    rs.getString("numero"),
                    rs.getString("descricao")
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Telefone: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados dos Pets:

    public void atualiza(Telefone telefone){

        String sql = "UPDATE telefone SET ddd = ?, numero = ?, descricao = ? WHERE idTel = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, telefone.getDdd());
            ps.setString(2, telefone.getNumero());
            ps.setString(3, telefone.getDescricao());
            ps.setInt(4, telefone.getIdTel());
            ps.executeUpdate();
            System.out.println("Dados do Telefone atualizados com sucesso!");
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar dados do telefone: " + e.getMessage());
        }
    }

    //Delete - Deleta dados do Pet:

    public void apaga(int idTel){

        String sql = "DELETE FROM telefone WHERE idTel = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTel);
            ps.executeUpdate();
            System.out.println("Dados do telefone apagados com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar apagar dados do telefone: " + e.getMessage());
        }
    }
  
}