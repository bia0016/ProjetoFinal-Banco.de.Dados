package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.StatusServico;

public class StatusServicoDAO {
    
    private Connection con;

    public StatusServicoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //Read - Devolve todos os Status

    public List<StatusServico> listarStatusServico(){

        String sql = "SELECT ID_STATUS, DESCRICAO FROM STATUS_SERVICO";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<StatusServico> statusServicos = new ArrayList<>();
            while(rs.next()){
                StatusServico k = new StatusServico(
                    rs.getString("DESCRICAO")
                );

                k.setIdStatus(rs.getInt("ID_STATUS"));
                statusServicos.add(k);
            }
            return statusServicos;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Status gerais: " + e.getMessage());
        }
    }

    //Read - Busca Status pelo ID

    public StatusServico buscarPorID(int idStatus){

        String sql = "SELECT ID_STATUS, DESCRICAO FROM STATUS_SERVICO WHERE ID_STATUS = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idStatus);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                StatusServico k = new StatusServico(
                    rs.getString("DESCRICAO")
                );

                k.setIdStatus(rs.getInt("ID_STATUS"));
                return k;
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Status do Serviço: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados do Status

    public void atualiza(StatusServico statusServico){

        String sql = "UPDATE STATUS_SERVICO SET DESCRICAO = ? WHERE ID_STATUS = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, statusServico.getDescricao());
            ps.setInt(2, statusServico.getIdStatus());
            ps.executeUpdate();
            System.out.println("Status do serviço atualizados com sucesso!");
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar Status do Serviço: " + e.getMessage());
        }
    }

}
