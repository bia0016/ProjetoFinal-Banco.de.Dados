package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.connection.ConnectionFactory;
import com.petshop.model.Dono;
import com.petshop.model.Pet;
import com.petshop.model.RegistroServico;
import com.petshop.model.Servico;
import com.petshop.model.StatusServico;

public class RegistroServicoDAO {

    private Connection con;

    public RegistroServicoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //create

    public void insert(RegistroServico registro) {

        String sql = "INSERT INTO REGISTRO_SERVICO (DATA_REGISTRO, CPF_DONO, ID_PET, ID_STATUS, ID_SERVICO) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, registro.getData());
            ps.setString(2, registro.getDono().getCpf());       
            ps.setInt(3, registro.getIdPet().getIdPet());       
            ps.setInt(4, registro.getStatus().getIdStatus());   
            ps.setInt(5, registro.getServico().getIdServico()); 
            ps.executeUpdate();

            System.out.println("Registro cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar registro: " + e.getMessage());
        }
    }

     //Read - Devolve todos os Endereços (com JOIN para trazer os dados completos)

    public List<RegistroServico> listarTodos() {

        String sql = "SELECT rs.ID_REGISTRO, rs.DATA_REGISTRO, " +
                     "d.CPF, d.NOME AS NOME_DONO, d.EMAIL, " +
                     "p.ID_PET, p.NOME AS NOME_PET, p.ESPECIE, p.RACA, p.PORTE, " +
                     "ss.ID_STATUS, ss.DESCRICAO AS DESC_STATUS, " +
                     "sv.ID_SERVICO, sv.TIPO, sv.DESCRICAO AS DESC_SERVICO, sv.PRECO " +
                     "FROM REGISTRO_SERVICO rs " +
                     "JOIN DONO d ON rs.CPF_DONO = d.CPF " +
                     "JOIN PET p ON rs.ID_PET = p.ID_PET " +
                     "JOIN STATUS_SERVICO ss ON rs.ID_STATUS = ss.ID_STATUS " +
                     "JOIN SERVICO sv ON rs.ID_SERVICO = sv.ID_SERVICO";

        List<RegistroServico> registros = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                Dono dono = new Dono(
                    rs.getString("CPF"),
                    rs.getString("NOME_DONO"),
                    rs.getString("EMAIL"),
                    null, null, null
                );

                Pet pet = new Pet(
                    rs.getInt("ID_PET"),
                    rs.getString("NOME_PET"),
                    rs.getString("ESPECIE"),
                    rs.getString("RACA"),
                    rs.getString("PORTE"),
                    null
                );

                StatusServico status = new StatusServico(
                    rs.getInt("ID_STATUS"),
                    rs.getString("DESC_STATUS")
                );

                Servico servico = new Servico(
                    rs.getInt("ID_SERVICO"),
                    rs.getString("TIPO"),
                    rs.getString("DESC_SERVICO"),
                    rs.getFloat("PRECO")
                );

                RegistroServico registro = new RegistroServico(
                    rs.getInt("ID_REGISTRO"),
                    rs.getString("DATA_REGISTRO"),
                    dono,
                    pet,
                    status,
                    servico
                );

                registros.add(registro);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar registros: " + e.getMessage());
        }

        return registros;
    }

    //Read - Busca Pet pelo ID

    public RegistroServico buscarPorId(int idRegistro) {

        String sql = "SELECT rs.ID_REGISTRO, rs.DATA_REGISTRO, " +
                     "d.CPF, d.NOME AS NOME_DONO, d.EMAIL, " +
                     "p.ID_PET, p.NOME AS NOME_PET, p.ESPECIE, p.RACA, p.PORTE, " +
                     "ss.ID_STATUS, ss.DESCRICAO AS DESC_STATUS, " +
                     "sv.ID_SERVICO, sv.TIPO, sv.DESCRICAO AS DESC_SERVICO, sv.PRECO " +
                     "FROM REGISTRO_SERVICO rs " +
                     "JOIN DONO d ON rs.CPF_DONO = d.CPF " +
                     "JOIN PET p ON rs.ID_PET = p.ID_PET " +
                     "JOIN STATUS_SERVICO ss ON rs.ID_STATUS = ss.ID_STATUS " +
                     "JOIN SERVICO sv ON rs.ID_SERVICO = sv.ID_SERVICO " +
                     "WHERE rs.ID_REGISTRO = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRegistro);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Dono dono = new Dono(
                    rs.getString("CPF"),
                    rs.getString("NOME_DONO"),
                    rs.getString("EMAIL"),
                    null, null, null
                );

                Pet pet = new Pet(
                    rs.getInt("ID_PET"),
                    rs.getString("NOME_PET"),
                    rs.getString("ESPECIE"),
                    rs.getString("RACA"),
                    rs.getString("PORTE"),
                    null
                );

                StatusServico status = new StatusServico(
                    rs.getInt("ID_STATUS"),
                    rs.getString("DESC_STATUS")
                );

                Servico servico = new Servico(
                    rs.getInt("ID_SERVICO"),
                    rs.getString("TIPO"),
                    rs.getString("DESC_SERVICO"),
                    rs.getFloat("PRECO")
                );

                return new RegistroServico(
                    rs.getInt("ID_REGISTRO"),
                    rs.getString("DATA_REGISTRO"),
                    dono,
                    pet,
                    status,
                    servico
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar registro: " + e.getMessage());
        }

        return null;
    }


    // Update

    public void atualizar(RegistroServico registro) {

        String sql = "UPDATE REGISTRO_SERVICO SET DATA_REGISTRO = ?, CPF_DONO = ?, " +
                     "ID_PET = ?, ID_STATUS = ?, ID_SERVICO = ? " +
                     "WHERE ID_REGISTRO = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, registro.getData());
            ps.setString(2, registro.getDono().getCpf());
            ps.setInt(3, registro.getIdPet().getIdPet());
            ps.setInt(4, registro.getStatus().getIdStatus());
            ps.setInt(5, registro.getServico().getIdServico());
            ps.setInt(6, registro.getIdRegistro());
            ps.executeUpdate();

            System.out.println("Registro atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar registro: " + e.getMessage());
        }
    }


    // Delete

    public void apagar(int idRegistro) {

        String sql = "DELETE FROM REGISTRO_SERVICO WHERE ID_REGISTRO = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRegistro);
            ps.executeUpdate();

            System.out.println("Registro apagado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar registro: " + e.getMessage());
        }
    }
}