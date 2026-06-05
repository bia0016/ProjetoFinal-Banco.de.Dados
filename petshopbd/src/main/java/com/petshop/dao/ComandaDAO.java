package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.Comanda;
import com.petshop.model.MetodoPagamento;

public class ComandaDAO {
    
    private Connection con;

    public ComandaDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(Comanda comanda){

        String sql = "INSERT INTO COMANDA (PRECO_TOTAL, ID_METODO, ID_REGISTRO) VALUES (?, ?, ?)";
    
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, comanda.getPrecoTotal());
            ps.setInt(2, comanda.getMetodoPagamento().getIdPag());
            ps.setInt(3, comanda.getIdRegistro());
            ps.executeUpdate();

            System.out.println("Comanda salva com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar salvar comanda: " + e.getMessage());
        }
    }

    //Read - Devolve todas as Comandas

    public List<Comanda> listarComanda(){

        String sql = "SELECT ID_COMANDA, PRECO_TOTAL, ID_METODO, ID_REGISTRO FROM COMANDA";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Comanda> comandas = new ArrayList<>();
            while(rs.next()){
                Comanda k = new Comanda(
                    rs.getInt("ID_COMANDA"),
                    rs.getFloat("PRECO_TOTAL"),
                    new MetodoPagamento(rs.getInt("ID_METODO"), null),
                    rs.getInt("ID_REGISTRO")
                );
                comandas.add(k);
            }
            return comandas;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Comandas: " + e.getMessage());
        }
    }

    //Read - Busca Comanda pelo ID

    public Comanda buscarPorID(int idComanda){

        String sql = "SELECT ID_COMANDA, PRECO_TOTAL, ID_METODO, ID_REGISTRO FROM COMANDA WHERE ID_COMANDA = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idComanda);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Comanda(
                    rs.getInt("ID_COMANDA"),
                    rs.getFloat("PRECO_TOTAL"),
                    new MetodoPagamento(rs.getInt("ID_METODO"), null),
                    rs.getInt("ID_REGISTRO")
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Comanda: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados da Comanda

    public void atualiza(Comanda comanda){

        String sql = "UPDATE COMANDA SET PRECO_TOTAL = ?, ID_METODO = ? WHERE ID_COMANDA = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, comanda.getPrecoTotal());
            ps.setInt(2, comanda.getMetodoPagamento().getIdPag());
            ps.setInt(3, comanda.getIdComanda());
            ps.executeUpdate();
            System.out.println("Dados da comanda atualizados com sucesso!");
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar dados da comanda: " + e.getMessage());
        }
    }

    //Delete - Deleta dados da Comanda

    public void apaga(int idComanda){

        String sql = "DELETE FROM COMANDA WHERE ID_COMANDA = ?";

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
