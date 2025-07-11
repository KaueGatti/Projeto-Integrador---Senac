package com.mycompany.projetointegradordesktop.JFrame;

import com.mycompany.projetointegradordesktop.DAO.RemedioDAO;
import com.mycompany.projetointegradordesktop.Model.RemedioTableModel;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;

public class IFRemedio extends javax.swing.JInternalFrame {

    RemedioTableModel model = new RemedioTableModel();

    public IFRemedio() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTRemedio = new javax.swing.JTable();
        jBCadastrarRemedio = new javax.swing.JButton();
        jBExcluirRemedio = new javax.swing.JButton();
        jBAtualizarRemedio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFPesquisa = new javax.swing.JTextField();
        jCBTipoPesquisa = new javax.swing.JComboBox<>();
        jBPesquisar = new javax.swing.JButton();

        setBorder(null);

        jTRemedio.setModel(new javax.swing.table.DefaultTableModel(
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
        jTRemedio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTRemedioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTRemedio);

        jBCadastrarRemedio.setBackground(new java.awt.Color(51, 90, 15));
        jBCadastrarRemedio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastrarRemedio.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrarRemedio.setText("Cadastrar Remédio");
        jBCadastrarRemedio.setBorder(null);
        jBCadastrarRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarRemedioActionPerformed(evt);
            }
        });

        jBExcluirRemedio.setBackground(new java.awt.Color(153, 51, 0));
        jBExcluirRemedio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBExcluirRemedio.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluirRemedio.setText("Excluir Remédio");
        jBExcluirRemedio.setBorder(null);
        jBExcluirRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirRemedioActionPerformed(evt);
            }
        });

        jBAtualizarRemedio.setBackground(new java.awt.Color(204, 204, 204));
        jBAtualizarRemedio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBAtualizarRemedio.setForeground(new java.awt.Color(0, 0, 0));
        jBAtualizarRemedio.setText("Atualizar Remédio");
        jBAtualizarRemedio.setBorder(null);
        jBAtualizarRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarRemedioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Remédios");

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
                .addComponent(jCBTipoPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                        .addComponent(jBCadastrarRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBAtualizarRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluirRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jBCadastrarRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBExcluirRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAtualizarRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTRemedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRemedioMouseClicked
        if (jTRemedio.getSelectedRow() != -1) {
            Remedio remedio = model.getRemedios().get(jTRemedio.getSelectedRow());
            if (evt.getClickCount() == 2) {
                openRemedioWindow(remedio);
            }
        }
    }//GEN-LAST:event_jTRemedioMouseClicked

    private void jBCadastrarRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarRemedioActionPerformed
        JFRemedio JFCadastrarRemedio = new JFRemedio();
        JFCadastrarRemedio.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (JFCadastrarRemedio.getResponse()) {
                    model.loadTable();
                }
            }
        }
        );
    }//GEN-LAST:event_jBCadastrarRemedioActionPerformed

    private void jBExcluirRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirRemedioActionPerformed
        if (jTRemedio.getSelectedRow() != -1) {
            RemedioDAO.delete(model.getRemedios().get(jTRemedio.getSelectedRow()));
            model.deleteLinha(jTRemedio.getSelectedRow());
        }
    }//GEN-LAST:event_jBExcluirRemedioActionPerformed

    private void jBAtualizarRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarRemedioActionPerformed
        if (jTRemedio.getSelectedRow() != -1) {
            Remedio remedio = model.getRemedios().get(jTRemedio.getSelectedRow());
            openRemedioWindow(remedio);
        }
    }//GEN-LAST:event_jBAtualizarRemedioActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        System.out.println(this.getDesktopPane());
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void loadTable() {
        jTRemedio.setModel(model);
        model.loadTable();
        jTRemedio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jTRemedio.setRowHeight(24);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(SwingConstants.CENTER);
        jTRemedio.getColumnModel().getColumn(2).setCellRenderer(centralizador);
        jTRemedio.getColumnModel().getColumn(3).setCellRenderer(centralizador);
        jTRemedio.getColumnModel().getColumn(4).setCellRenderer(centralizador);
        jTRemedio.getColumnModel().getColumn(5).setCellRenderer(centralizador);
    }

    private void openRemedioWindow(Remedio remedio) {
        JFAtualizarRemedio JFAtualizarRemedio = new JFAtualizarRemedio(remedio);
        JFAtualizarRemedio.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (JFAtualizarRemedio.getResponse() == 1) {
                    Remedio remedioUpdated = JFAtualizarRemedio.getRemedioUpdated();
                    model.setValueAt(remedioUpdated.getLaboratorio(), jTRemedio.getSelectedRow(), 0);
                    model.setValueAt(remedioUpdated.getDescricao(), jTRemedio.getSelectedRow(), 1);
                    model.setValueAt(remedioUpdated.getValorCusto(), jTRemedio.getSelectedRow(), 3);
                    model.setValueAt(remedioUpdated.getValorVenda(), jTRemedio.getSelectedRow(), 4);
                    RemedioDAO.update(remedioUpdated);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizarRemedio;
    private javax.swing.JButton jBCadastrarRemedio;
    private javax.swing.JButton jBExcluirRemedio;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<String> jCBTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFPesquisa;
    private javax.swing.JTable jTRemedio;
    // End of variables declaration//GEN-END:variables
}
