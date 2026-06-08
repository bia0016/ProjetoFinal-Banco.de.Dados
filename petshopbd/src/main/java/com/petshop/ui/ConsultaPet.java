package com.petshop.ui;

import com.petshop.model.Pet;
import com.petshop.dao.PetDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ConsultaPet extends javax.swing.JPanel {

    private PetDAO petDAO = new PetDAO();
    private TelaInicial telaInicial;

    public ConsultaPet(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
        initComponents();
        configurarBotoes();
        carregarTabela(petDAO.listarPets());
    }

    public ConsultaPet() {
        initComponents();
        configurarBotoes();
        carregarTabela(petDAO.listarPets());
    }

    private void configurarBotoes() {

        jButton1Pesquisar.addActionListener(e -> {
            String filtro = jTextField1.getText().trim().toLowerCase();
            List<Pet> todos = petDAO.listarPets();

            if (filtro.isEmpty()) {
                carregarTabela(todos);
            } else {
                List<Pet> filtrados = todos.stream()
                    .filter(p -> p.getNome().toLowerCase().contains(filtro)
                              || String.valueOf(p.getIdPet()).contains(filtro))
                    .collect(java.util.stream.Collectors.toList());
                carregarTabela(filtrados);
            }
        });

        jButton1.addActionListener(e -> {
            int linha = jTable1.getSelectedRow();
            if (linha < 0) {
                JOptionPane.showMessageDialog(this, "Selecione um pet na tabela.");
                return;
            }
            Pet pet = petDAO.buscarPorID((Integer) jTable1.getValueAt(linha, 0));
            if (pet == null) {
                JOptionPane.showMessageDialog(this, "Pet não encontrado.");
                return;
            }
            JOptionPane.showMessageDialog(this,
                "ID: "      + pet.getIdPet()   + "\n" +
                "Nome: "    + pet.getNome()     + "\n" +
                "Espécie: " + pet.getEspecie()  + "\n" +
                "Raça: "    + pet.getRaca()     + "\n" +
                "Porte: "   + pet.getPorte(),
                "Dados do Pet", JOptionPane.INFORMATION_MESSAGE);
        });

        jButton2.addActionListener(e -> {
            int linha = jTable1.getSelectedRow();
            if (linha < 0) {
                JOptionPane.showMessageDialog(this, "Selecione um pet na tabela para editar.");
                return;
            }
            Pet pet = petDAO.buscarPorID((Integer) jTable1.getValueAt(linha, 0));
            if (pet == null) {
                JOptionPane.showMessageDialog(this, "Pet não encontrado.");
                return;
            }

            PetCadastro telaCadastro = new PetCadastro();
            telaCadastro.preencherParaEdicao(pet);

            if (telaInicial != null) {
                telaInicial.abrirTela(telaCadastro);
            } else {
                JFrame frame = new JFrame("Editar Pet");
                frame.setContentPane(telaCadastro);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        jButton3.addActionListener(e -> {
            int linha = jTable1.getSelectedRow();
            if (linha < 0) {
                JOptionPane.showMessageDialog(this, "Selecione um pet na tabela para excluir.");
                return;
            }
            int idPet = (Integer) jTable1.getValueAt(linha, 0);
            String nomePet = jTable1.getValueAt(linha, 1).toString();
            int confirm = JOptionPane.showConfirmDialog(this,
                "Confirma exclusão do pet \"" + nomePet + "\"?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    petDAO.apaga(idPet);
                    JOptionPane.showMessageDialog(this, "Pet removido com sucesso!");
                    carregarTabela(petDAO.listarPets());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        });
    }

    private void carregarTabela(List<Pet> pets) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Pet p : pets) {
            model.addRow(new Object[]{
                p.getIdPet(), p.getNome(), p.getEspecie(), p.getRaca(), p.getPorte()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1Pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Consultar Pet");

        jLabel2.setText("Nome / ID:");

        jButton1Pesquisar.setText("Pesquisar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nome", "Espécie", "Raça", "Porte"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Selecionar");

        jButton2.setText("Editar");

        jButton3.setText("Excluir");

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
                        .addComponent(jButton1Pesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
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
                    .addComponent(jButton1Pesquisar))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1Pesquisar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}