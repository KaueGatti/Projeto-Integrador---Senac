package com.mycompany.projetointegradordesktop.JFrame;

import com.mycompany.projetointegradordesktop.DAO.DrogariaDAO;
import com.mycompany.projetointegradordesktop.Model.DrogariaTableModel;
import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;

public class IFDrogaria extends javax.swing.JInternalFrame {

    DrogariaTableModel model = new DrogariaTableModel();

    public IFDrogaria() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFPesquisa = new javax.swing.JTextField();
        jCBTipoPesquisa = new javax.swing.JComboBox<>();
        jBPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDrogaria = new javax.swing.JTable();
        jBCadastrarDrogaria = new javax.swing.JButton();
        jBExcluirDrogaria = new javax.swing.JButton();
        jBAtualizarDrogaria = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Drogarias");

        jTFPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jCBTipoPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBPesquisar.setBackground(new java.awt.Color(153, 153, 153));
        jBPesquisar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        jBPesquisar.setText("Pesquisar");
        jBPesquisar.setBorder(null);
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBTipoPesquisa, 0, 282, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTDrogaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTDrogaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDrogariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTDrogaria);

        jBCadastrarDrogaria.setBackground(new java.awt.Color(51, 90, 15));
        jBCadastrarDrogaria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastrarDrogaria.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrarDrogaria.setText("Cadastrar Drogaria");
        jBCadastrarDrogaria.setBorder(null);
        jBCadastrarDrogaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarDrogariaActionPerformed(evt);
            }
        });

        jBExcluirDrogaria.setBackground(new java.awt.Color(153, 51, 0));
        jBExcluirDrogaria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBExcluirDrogaria.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluirDrogaria.setText("Excluir Drogaria");
        jBExcluirDrogaria.setBorder(null);
        jBExcluirDrogaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirDrogariaActionPerformed(evt);
            }
        });

        jBAtualizarDrogaria.setBackground(new java.awt.Color(204, 204, 204));
        jBAtualizarDrogaria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBAtualizarDrogaria.setForeground(new java.awt.Color(0, 0, 0));
        jBAtualizarDrogaria.setText("Atualizar Drogaria");
        jBAtualizarDrogaria.setBorder(null);
        jBAtualizarDrogaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarDrogariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBCadastrarDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBAtualizarDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluirDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBCadastrarDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBExcluirDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAtualizarDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jTDrogariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDrogariaMouseClicked
        if (jTDrogaria.getSelectedRow() != -1) {
            Drogaria drogaria = model.getDrogarias().get(jTDrogaria.getSelectedRow());
            if (evt.getClickCount() == 2) {
                openDrogariaWindow(drogaria);
            }
        }
    }//GEN-LAST:event_jTDrogariaMouseClicked

    private void jBCadastrarDrogariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarDrogariaActionPerformed
        openDrogariaWindow(null);
    }//GEN-LAST:event_jBCadastrarDrogariaActionPerformed

    private void jBExcluirDrogariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirDrogariaActionPerformed
        if (jTDrogaria.getSelectedRow() != -1) {
            DrogariaDAO.delete(model.getDrogarias().get(jTDrogaria.getSelectedRow()));
            model.deleteLinha(jTDrogaria.getSelectedRow());
        }
    }//GEN-LAST:event_jBExcluirDrogariaActionPerformed

    private void jBAtualizarDrogariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarDrogariaActionPerformed
        if (jTDrogaria.getSelectedRow() != -1) {
            Drogaria drogaria = model.getDrogarias().get(jTDrogaria.getSelectedRow());
            openDrogariaWindow(drogaria);
        }
    }//GEN-LAST:event_jBAtualizarDrogariaActionPerformed

    private void loadTable() {
        jTDrogaria.setModel(model);
        model.loadTable();
        jTDrogaria.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jTDrogaria.setRowHeight(24);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(SwingConstants.CENTER);
        jTDrogaria.getColumnModel().getColumn(1).setCellRenderer(centralizador);
        jTDrogaria.getColumnModel().getColumn(4).setCellRenderer(centralizador);
        jTDrogaria.getColumnModel().getColumn(7).setCellRenderer(centralizador);
    }
    
    private void openDrogariaWindow(Drogaria drogaria) {
        JFDrogaria JFDrogaria;
        if (drogaria != null) {
            JFDrogaria = new JFDrogaria(drogaria);
        } else {
            JFDrogaria = new JFDrogaria();
        }
        JFDrogaria.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (JFDrogaria.getResponse() == 1) {
                    Drogaria drogariaUpdated = JFDrogaria.getDrogariaUpdated();
                    model.setValueAt(drogariaUpdated.getNumero(), jTDrogaria.getSelectedRow(), 2);
                    model.setValueAt(drogariaUpdated.getRua(), jTDrogaria.getSelectedRow(), 3);
                    model.setValueAt(drogariaUpdated.getCep(), jTDrogaria.getSelectedRow(), 4);
                    model.setValueAt(drogariaUpdated.getBairro(), jTDrogaria.getSelectedRow(), 5);
                    model.setValueAt(drogariaUpdated.getCidade(), jTDrogaria.getSelectedRow(), 6);
                    model.setValueAt(drogariaUpdated.getEstado(), jTDrogaria.getSelectedRow(), 7);
                    model.setValueAt(drogariaUpdated.getComplemento(), jTDrogaria.getSelectedRow(), 8);
                    DrogariaDAO.update(drogariaUpdated);
                } else if (JFDrogaria.getResponse() == 2) {
                    DrogariaDAO.create(JFDrogaria.getNewDrogaria());
                    model.loadTable();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizarDrogaria;
    private javax.swing.JButton jBCadastrarDrogaria;
    private javax.swing.JButton jBExcluirDrogaria;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<String> jCBTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDrogaria;
    private javax.swing.JTextField jTFPesquisa;
    // End of variables declaration//GEN-END:variables
}
