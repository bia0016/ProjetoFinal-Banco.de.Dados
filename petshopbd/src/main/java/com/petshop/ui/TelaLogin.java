package com.petshop.ui;

import java.awt.BorderLayout;
import java.util.logging.Logger;

public class TelaLogin extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(TelaLogin.class.getName());

    public TelaLogin() {
        initComponents();
        painelConteudo.setLayout(new BorderLayout());
        // Abre a tela de Donos por padrão ao iniciar
        abrirTela(new CadastroTutor());
    }

    private void abrirTela(javax.swing.JPanel tela) {
        painelConteudo.removeAll();
        painelConteudo.add(tela, BorderLayout.CENTER);
        painelConteudo.revalidate();
        painelConteudo.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnServicos = new javax.swing.JButton();
        btnPets = new javax.swing.JButton();
        btnDonos = new javax.swing.JButton();
        btnRegistros = new javax.swing.JButton();
        btnComandas = new javax.swing.JButton();
        jBPagamento = new javax.swing.JButton();
        btnStatus = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
        painelConteudo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setText("Pet Tops");

        btnDonos.setText("Dono");
        btnDonos.addActionListener(e -> abrirTela(new CadastroTutor()));

        btnConsulta.setText("Consulta Dono");
        btnConsulta.addActionListener(e -> abrirTela(new ConsultaDono()));

        btnPets.setText("Pets");
        btnPets.addActionListener(e -> abrirTela(new PetCadastro()));

        btnServicos.setText("Serviços");
        btnServicos.addActionListener(e -> abrirTela(new CadastrarServicos()));

        btnRegistros.setText("Registros");
        btnRegistros.addActionListener(e -> abrirTela(new RegistroServico()));

        btnComandas.setText("Comandas");
        btnComandas.addActionListener(e -> abrirTela(new TelaComanda()));

        btnStatus.setText("Status");
        btnStatus.addActionListener(e -> abrirTela(new Status()));

        jBPagamento.setText("Método de Pag...");
        jBPagamento.addActionListener(e -> abrirTela(new TelaMetoPagament()));

        javax.swing.GroupLayout painelConteudoLayout = new javax.swing.GroupLayout(painelConteudo);
        painelConteudo.setLayout(painelConteudoLayout);
        painelConteudoLayout.setHorizontalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );
        painelConteudoLayout.setVerticalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnDonos, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPets, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18,18,18)
                .addComponent(painelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1).addGap(31,31,31)
                        .addComponent(btnDonos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPets)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnServicos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnComandas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBPagamento)
                        .addGap(0, 195, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(painelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComandas;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnDonos;
    private javax.swing.JButton btnPets;
    private javax.swing.JButton btnRegistros;
    private javax.swing.JButton btnServicos;
    private javax.swing.JButton btnStatus;
    private javax.swing.JButton jBPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelConteudo;
    // End of variables declaration//GEN-END:variables
}
