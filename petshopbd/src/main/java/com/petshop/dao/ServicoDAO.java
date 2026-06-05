package com.petshop.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.Servico;

public class ServicoDAO{
    
    private Connection con;

    public ServicoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(Servico servico){

        String sql = "INSERT INTO SERVICO (TIPO, DESCRICAO, PRECO) VALUES (?, ?, ?)";
    
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, servico.getTipo());
            ps.setString(2, servico.getDescricao());
            ps.setFloat(3, servico.getPreco());
            ps.executeUpdate();

            System.out.println("Serviço ativado com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar ativar serviço: " + e.getMessage());
        }
    }

    //Read - Devolve todos os Serviços

    public List<Servico> listarServico(){

        String sql = "SELECT ID_SERVICO, TIPO, DESCRICAO, PRECO FROM SERVICO";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Servico> servicos = new ArrayList<>();
            while(rs.next()){
                Servico k = new Servico(
                    rs.getInt("ID_SERVICO"),
                    rs.getString("TIPO"),
                    rs.getString("DESCRICAO"),
                    rs.getFloat("PRECO")
                );
                servicos.add(k);
            }
            return servicos;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Serviços: " + e.getMessage());
        }
    }

    //Read - Busca Serviço pelo ID

    public Servico buscarPorID(int idServico){

        String sql = "SELECT ID_SERVICO, TIPO, DESCRICAO, PRECO FROM SERVICO WHERE ID_SERVICO = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idServico);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Servico(
                    rs.getInt("ID_SERVICO"),
                    rs.getString("TIPO"),
                    rs.getString("DESCRICAO"),
                    rs.getFloat("PRECO")
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Serviço: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados dos Serviços

    public void atualiza(Servico servico){

        String sql = "UPDATE SERVICO SET TIPO = ?, DESCRICAO = ?, PRECO = ? WHERE ID_SERVICO = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, servico.getTipo());
            ps.setString(2, servico.getDescricao());
            ps.setFloat(3, servico.getPreco());
            ps.setInt(4, servico.getIdServico());
            ps.executeUpdate();
            System.out.println("Dados do serviço atualizados com sucesso!");
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar dados do serviço: " + e.getMessage());
        }
    }

    //Delete - Deleta dados do Serviço

    public void apaga(int idServico){

        String sql = "DELETE FROM SERVICO WHERE ID_SERVICO = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idServico);
            ps.executeUpdate();
            System.out.println("Dados do serviço apagados com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar apagar dados do Serviço: " + e.getMessage());
        }
    }
}
