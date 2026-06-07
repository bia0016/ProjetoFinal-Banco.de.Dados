package com.petshop.ui;

import com.petshop.model.*;
import com.petshop.service.ComandaService;
import com.petshop.dao.*;
import javax.swing.*;
import java.util.List;

public class TelaComanda extends javax.swing.JPanel {

    private ComandaService comandaService = new ComandaService();
    private RegistroServicoDAO registroDAO = new RegistroServicoDAO();
    private MetodoPagamentoDAO metodoPagamentoDAO = new MetodoPagamentoDAO();

    public TelaComanda() {
        initComponents();
        carregarCombos();
        configurarBotoes();
    }

    private void carregarCombos() {
        // Combo de registros
        jComboBox2.removeAllItems();
        for (com.petshop.model.RegistroServico r : registroDAO.listarTodos()) {
            jComboBox2.addItem(r.getIdRegistro() + " - " + r.getDono().getNome());
        }
        // Combo de métodos de pagamento
        jComboBox1.removeAllItems();
        for (MetodoPagamento m : metodoPagamentoDAO.listarMetodoPagamento()) {
            jComboBox1.addItem(m.getIdPag() + " - " + m.getDescricao());
        }
    }

    private void configurarBotoes() {

        // Ao selecionar um registro, preenche os labels com os dados
        jComboBox2.addActionListener(e -> {
            if (jComboBox2.getSelectedItem() == null) return;
            int idRegistro = Integer.parseInt(jComboBox2.getSelectedItem().toString().split(" - ")[0]);
            com.petshop.model.RegistroServico r = registroDAO.buscarPorId(idRegistro);
            if (r != null) {
                jLabel9.setText(r.getDono().getNome());
                jLabel10.setText(r.getIdPet().getNome());
                jLabel11.setText(r.getServico().getTipo());
                jLabel12.setText("R$ " + r.getServico().getPreco());
            }
        });

        // Botão Finalizar → salva a comanda
        jButton1.addActionListener(e -> {
            try {
                if (jComboBox2.getSelectedItem() == null || jComboBox1.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(this, "Selecione o registro e o método de pagamento.");
                    return;
                }
                int idRegistro = Integer.parseInt(jComboBox2.getSelectedItem().toString().split(" - ")[0]);
                int idMetodo = Integer.parseInt(jComboBox1.getSelectedItem().toString().split(" - ")[0]);

                com.petshop.model.RegistroServico r = registroDAO.buscarPorId(idRegistro);
                MetodoPagamento metodo = metodoPagamentoDAO.buscarPorID(idMetodo);

                Comanda comanda = new Comanda(
                    null,
                    r.getServico().getPreco(),
                    metodo,
                    idRegistro
                );
                comandaService.cadastrarComanda(comanda);
                JOptionPane.showMessageDialog(this, "Comanda finalizada com sucesso!");
                carregarCombos();

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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setText("Comanda");
        jLabel2.setText("Registro:");
        jLabel3.setText("Cliente");
        jLabel4.setText("Pet:");
        jLabel5.setText("Serviço:");
        jLabel6.setText("Valor Total:");
        jLabel7.setText("Método Pagamento:");
        jButton1.setText("Finalizar");
        jLabel8.setText(" ");
        jLabel9.setText(" ");
        jLabel10.setText(" ");
        jLabel11.setText(" ");
        jLabel12.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel3).addGap(39,39,39).addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel4).addGap(39,39,39).addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel5).addGap(39,39,39).addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel6).addGap(18,18,18).addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26,26,26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(jLabel8).addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(jLabel12))
                .addGap(27,27,27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE).addComponent(jButton1)
                .addGap(27,27,27))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
