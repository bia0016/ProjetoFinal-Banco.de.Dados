package com.petshop.ui;

import com.petshop.model.MetodoPagamento;
import com.petshop.dao.MetodoPagamentoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TelaMetoPagament extends javax.swing.JPanel {

    private MetodoPagamentoDAO metodoPagamentoDAO = new MetodoPagamentoDAO();

    public TelaMetoPagament() {
        initComponents();
        configurarBotoes();
        carregarTabela();
    }

    private void configurarBotoes() {

        // Botão Salvar
        jButton1.addActionListener(e -> {
            try {
                String tipo = jTextField1.getText().trim();
                if (tipo.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Informe o tipo do método de pagamento.");
                    return;
                }
                MetodoPagamento metodo = new MetodoPagamento(null, tipo);
                metodoPagamentoDAO.insert(metodo);
                JOptionPane.showMessageDialog(this, "Método de pagamento cadastrado com sucesso!");
                jTextField1.setText("");
                carregarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }

    private void carregarTabela() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        List<MetodoPagamento> lista = metodoPagamentoDAO.listarMetodoPagamento();
        for (MetodoPagamento m : lista) {
            model.addRow(new Object[]{m.getIdPag(), m.getDescricao()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setText("Método de Pagamento");
        jLabel2.setText("Tipo:");
        jButton1.setText("Salvar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null,null},{null,null},{null,null},{null,null}},
            new String [] {"ID","Tipo"}
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18).addComponent(jButton1).addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
