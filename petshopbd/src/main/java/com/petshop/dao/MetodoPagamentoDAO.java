package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.MetodoPagamento;

public class MetodoPagamentoDAO {
    
    private Connection con;

    public MetodoPagamentoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(MetodoPagamento metodoPagamento){

        String sql = "INSERT INTO METODO_PAGAMENTO (TIPO) VALUES (?)";
    
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, metodoPagamento.getDescricao());
            ps.executeUpdate();

            System.out.println("Método cadastrado com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar cadastrar método: " + e.getMessage());
        }
    }

    //Read - Devolve todos os Métodos de Pagamento

    public List<MetodoPagamento> listarMetodoPagamento(){

        String sql = "SELECT ID_METODO, TIPO FROM METODO_PAGAMENTO";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<MetodoPagamento> metodoPagamentos = new ArrayList<>();
            while(rs.next()){
                MetodoPagamento k = new MetodoPagamento(
                    rs.getInt("ID_METODO"),
                    rs.getString("TIPO")
                );
                metodoPagamentos.add(k);
            }
            return metodoPagamentos;
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao listar Métodos de Pagamentos: " + e.getMessage());
        }
    }

    //Read - Busca Método de Pagamento pelo ID

    public MetodoPagamento buscarPorID(int idPag){

        String sql = "SELECT ID_METODO, TIPO FROM METODO_PAGAMENTO WHERE ID_METODO = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPag);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new MetodoPagamento(
                    rs.getInt("ID_METODO"),
                    rs.getString("TIPO")
                );
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar Método de Pagamento: " + e.getMessage());
        }
        return null;
    }

    //Update - Atualizar dados do Método de Pagamento

    public void atualiza(MetodoPagamento metodoPagamento){

        String sql = "UPDATE METODO_PAGAMENTO SET TIPO = ? WHERE ID_METODO = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, metodoPagamento.getDescricao());
            ps.setInt(2, metodoPagamento.getIdPag());
            ps.executeUpdate();
            System.out.println("Método de Pagamento atualizados com sucesso!");
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar Método de Pagamento: " + e.getMessage());
        }
    }

    //Delete - Deleta dados do Método de Pagamento

    public void apaga(int idPag){

        String sql = "DELETE FROM METODO_PAGAMENTO WHERE ID_METODO = ?";

        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPag);
            ps.executeUpdate();
            System.out.println("Método de Pagamento apagados com sucesso!");
        }
        catch(SQLException e){

            throw new RuntimeException("Erro ao tentar apagar Método de Pagamento: " + e.getMessage());
        }
    }

}
