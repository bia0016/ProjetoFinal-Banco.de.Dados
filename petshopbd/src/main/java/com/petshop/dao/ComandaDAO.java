package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.Comanda;

public class ComandaDAO {
    
    private Connection con;

    public ComandaDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(Comanda comanda){

        String sql = "INSERT INTO comanda(idComanda, precoTotal) VALUES (?, ?)";
    
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, comanda.getIdComanda());
            ps.setFloat(2, comanda.getPrecoTotal());
            ps.executeUpdate();

            System.out.println("Comanda salva com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar salvar comanda: " + e.getMessage());
        }
    }

    //Read - Devolve todos os Endereços

    public List<Comanda> listarComanda(){

        String sql = "SELECT idComanda, precoTotal FROM comanda";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Comanda> comandas = new ArrayList<>();
            while(rs.next()){
                Comanda k = new Comanda(
                    rs.getInt("idComanda"),
                    rs.getFloat("precoTotal")
                );
                comandas.add(k);
            }
            return comandas;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Comandas: " + e.getMessage());
        }
    }

    //Read - Busca Pet pelo ID

    public Comanda buscarPorID(int idComanda){

        String sql = "SELECT * FROM comanda WHERE idComanda = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idComanda);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Comanda(

                    rs.getInt("idComanda"),
                    rs.getFloat("precoTotal")
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Comanda: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados dos Pets:

    public void atualiza(Comanda comanda){

        String sql = "UPDATE comanda SET precoTotal = ? WHERE idComanda = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, comanda.getPrecoTotal());
            ps.setInt(2, comanda.getIdComanda());
            ps.executeUpdate();
            System.out.println("Dados da comanda atualizados com sucesso!");
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar dados da comanda: " + e.getMessage());
        }
    }

    //Delete - Deleta dados do Pet:

    public void apaga(int idComanda){

        String sql = "DELETE FROM comanda WHERE idComanda = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idComanda);
            ps.executeUpdate();
            System.out.println("Dados da comanda apagados com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar apagar dados da comanda: " + e.getMessage());
        }
    }
    
}
