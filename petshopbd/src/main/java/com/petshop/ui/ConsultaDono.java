package com.petshop.ui;

import com.petshop.model.Dono;
import com.petshop.dao.DonoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ConsultaDono extends javax.swing.JPanel {

    private DonoDAO donoDAO = new DonoDAO();

    public ConsultaDono() {
        initComponents();
        configurarBotoes();
        carregarTabela(donoDAO.listarDonos());
    }

    private void configurarBotoes() {

        // Botão Pesquisar → filtra pelo nome digitado
        jButton1.addActionListener(e -> {
            String nomeBusca = jTextField1.getText().trim().toLowerCase();
            List<Dono> todos = donoDAO.listarDonos();

            if (nomeBusca.isEmpty()) {
                carregarTabela(todos);
            } else {
                List<Dono> filtrados = todos.stream()
                    .filter(d -> d.getNome().toLowerCase().contains(nomeBusca))
                    .collect(java.util.stream.Collectors.toList());
                carregarTabela(filtrados);
            }
        });

        // Botão Selecionar → abre tela de edição com os dados do dono selecionado
        jButton2.addActionListener(e -> {
            int linha = jTable1.getSelectedRow();
            if (linha < 0) {
                JOptionPane.showMessageDialog(this, "Selecione um dono na tabela.");
                return;
            }
            String cpf = jTable1.getValueAt(linha, 2).toString();
            Dono dono = donoDAO.buscarPorCPF(cpf);
            if (dono == null) {
                JOptionPane.showMessageDialog(this, "Dono não encontrado.");
                return;
            }
            // Exibe os dados do dono selecionado num dialog
            JOptionPane.showMessageDialog(this,
                "CPF: " + dono.getCpf() + "\n" +
                "Nome: " + dono.getNome() + "\n" +
                "E-mail: " + dono.getEmail(),
                "Dados do Dono", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void carregarTabela(List<Dono> donos) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Dono d : donos) {
            model.addRow(new Object[]{d.getNome(), d.getEmail(), d.getCpf()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Consultar Dono");

        jLabel2.setText("CPF :");

        jButton1.setText("Pesquisar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "E-mail", "CPF"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Selecionar");

        jButton3.setText("Editar");

        jButton4.setText("Excluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
