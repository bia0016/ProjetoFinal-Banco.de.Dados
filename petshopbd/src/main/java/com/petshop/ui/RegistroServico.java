package com.petshop.ui;

import com.petshop.model.*;
import com.petshop.service.RegistroServicoService;
import com.petshop.dao.*;
import javax.swing.*;

public class RegistroServico extends javax.swing.JPanel {

    private RegistroServicoService registroService = new RegistroServicoService();
    private DonoDAO donoDAO = new DonoDAO();
    private PetDAO petDAO = new PetDAO();
    private ServicoDAO servicoDAO = new ServicoDAO();
    private StatusServicoDAO statusDAO = new StatusServicoDAO();

    public RegistroServico() {
        initComponents();
        carregarCombos();
        configurarBotoes();
    }

    private void carregarCombos() {
        // Dono
        jComboBox1.removeAllItems();
        for (Dono d : donoDAO.listarDonos()) {
            jComboBox1.addItem(d.getCpf() + " - " + d.getNome());
        }
        // Pet
        jComboBox2.removeAllItems();
        for (Pet p : petDAO.listarPets()) {
            jComboBox2.addItem(p.getIdPet() + " - " + p.getNome());
        }
        // Serviço
        jComboBox3.removeAllItems();
        for (com.petshop.model.Servico s : servicoDAO.listarServico()) {
            jComboBox3.addItem(s.getIdServico() + " - " + s.getTipo());
        }
        // Status
        jComboBox4.removeAllItems();
        for (StatusServico st : statusDAO.listarStatusServico()) {
            jComboBox4.addItem(st.getIdStatus() + " - " + st.getDescricao());
        }
    }

    private void configurarBotoes() {

        // Botão Registrar
        jButton1.addActionListener(e -> {
            try {
                String cpf = jComboBox1.getSelectedItem().toString().split(" - ")[0];
                int idPet = Integer.parseInt(jComboBox2.getSelectedItem().toString().split(" - ")[0]);
                int idServico = Integer.parseInt(jComboBox3.getSelectedItem().toString().split(" - ")[0]);
                int idStatus = Integer.parseInt(jComboBox4.getSelectedItem().toString().split(" - ")[0]);
                String data = jTextField1.getText().trim();

                Dono dono = donoDAO.buscarPorCPF(cpf);
                Pet pet = petDAO.buscarPorID(idPet);
                com.petshop.model.Servico servico = servicoDAO.buscarPorID(idServico);
                StatusServico status = statusDAO.buscarPorID(idStatus);

                com.petshop.model.RegistroServico registro = new com.petshop.model.RegistroServico(
                    data, dono, pet, status, servico
                );

                registroService.cadastrarRegistroServico(registro);
                JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
                jTextField1.setText("");
                jTextField2.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setText("Registro de Serviço");
        jLabel2.setText("Dono:");
        jLabel3.setText("Pet:");
        jLabel4.setText("Serviço:");
        jButton1.setText("Registrar");
        jLabel6.setText("Status:");
        jLabel5.setText("Data:");
        jLabel7.setText("Horário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(18,18,18).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel3).addGap(18,18,18).addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel4).addGap(18,18,18).addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel6).addGap(18,18,18).addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel5).addGap(18,18,18).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel7).addGap(18,18,18).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9,9,9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton1)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
