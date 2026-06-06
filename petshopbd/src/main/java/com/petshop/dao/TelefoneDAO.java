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

        String sql = "INSERT INTO TELEFONE (DDD, NUMERO, DESCRICAO) VALUES (?, ?, ?)";
    
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, telefone.getDdd());
            ps.setString(2, telefone.getNumero());
            ps.setString(3, telefone.getDescricao());
            ps.executeUpdate();

            System.out.println("Telefone cadastrado com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar cadastrar telefone: " + e.getMessage());
        }
    }

    //Read - Devolve todos os Telefones

    public List<Telefone> listarTelefone(){

        String sql = "SELECT ID_TELEFONE, DDD, NUMERO, DESCRICAO FROM TELEFONE";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Telefone> telefones = new ArrayList<>();
            while(rs.next()){
                Telefone k = new Telefone(
                    rs.getString("DDD"),
                    rs.getString("NUMERO"),
                    rs.getString("DESCRICAO")
                );

                k.setIdTel(rs.getInt("ID_TELEFONE"));
                telefones.add(k);
            }
            return telefones;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Telefones: " + e.getMessage());
        }
    }

    //Read - Busca Telefone pelo ID

    public Telefone buscarPorID(int idTel){

        String sql = "SELECT ID_TELEFONE, DDD, NUMERO, DESCRICAO FROM TELEFONE WHERE ID_TELEFONE = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTel);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Telefone k = new Telefone(
                    rs.getString("DDD"),
                    rs.getString("NUMERO"),
                    rs.getString("DESCRICAO")
                );
                k.setIdTel(rs.getInt("ID_TELEFONE"));
                return k;

            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Telefone: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados do Telefone

    public void atualiza(Telefone telefone){

        String sql = "UPDATE TELEFONE SET DDD = ?, NUMERO = ?, DESCRICAO = ? WHERE ID_TELEFONE = ?";

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

    //Delete - Deleta dados do Telefone

    public void apaga(int idTel){

        String sql = "DELETE FROM TELEFONE WHERE ID_TELEFONE = ?";

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
