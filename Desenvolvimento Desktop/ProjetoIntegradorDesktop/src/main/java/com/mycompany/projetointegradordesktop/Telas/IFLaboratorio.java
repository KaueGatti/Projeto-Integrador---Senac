package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.DAO.LaboratorioDAO;
import com.mycompany.projetointegradordesktop.Model.LaboratorioTableModel;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;

public class IFLaboratorio extends javax.swing.JInternalFrame {

    LaboratorioTableModel model = new LaboratorioTableModel();

    public IFLaboratorio() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBAtualizarLaboratorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFPesquisa = new javax.swing.JTextField();
        jCBTipoPesquisa = new javax.swing.JComboBox<>();
        jBPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLaboratorio = new javax.swing.JTable();
        jBCadastrarLaboratorio = new javax.swing.JButton();
        jBExcluirLaboratorio = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setMaximizable(true);

        jBAtualizarLaboratorio.setBackground(new java.awt.Color(204, 204, 204));
        jBAtualizarLaboratorio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBAtualizarLaboratorio.setForeground(new java.awt.Color(0, 0, 0));
        jBAtualizarLaboratorio.setText("Atualizar Laboratório");
        jBAtualizarLaboratorio.setBorder(null);
        jBAtualizarLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarLaboratorioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Laboratórios");

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

        jTLaboratorio.setModel(new javax.swing.table.DefaultTableModel(
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
        jTLaboratorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTLaboratorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTLaboratorio);

        jBCadastrarLaboratorio.setBackground(new java.awt.Color(51, 90, 15));
        jBCadastrarLaboratorio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastrarLaboratorio.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrarLaboratorio.setText("Cadastrar Laboratório");
        jBCadastrarLaboratorio.setBorder(null);
        jBCadastrarLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarLaboratorioActionPerformed(evt);
            }
        });

        jBExcluirLaboratorio.setBackground(new java.awt.Color(153, 51, 0));
        jBExcluirLaboratorio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBExcluirLaboratorio.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluirLaboratorio.setText("Excluir Laboratório");
        jBExcluirLaboratorio.setBorder(null);
        jBExcluirLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirLaboratorioActionPerformed(evt);
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
                        .addComponent(jBCadastrarLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBAtualizarLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluirLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jBCadastrarLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBExcluirLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAtualizarLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAtualizarLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarLaboratorioActionPerformed
        if (jTLaboratorio.getSelectedRow() != -1) {
            Laboratorio lab = model.getLaboratorios().get(jTLaboratorio.getSelectedRow());
            openLaboratorioWindow(lab);
        }
    }//GEN-LAST:event_jBAtualizarLaboratorioActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed

    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jTLaboratorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLaboratorioMouseClicked
        if (jTLaboratorio.getSelectedRow() != -1) {
            Laboratorio lab = model.getLaboratorios().get(jTLaboratorio.getSelectedRow());
            if (evt.getClickCount() == 2) {
                openLaboratorioWindow(lab);
            }
        }
    }//GEN-LAST:event_jTLaboratorioMouseClicked

    private void jBCadastrarLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarLaboratorioActionPerformed
        openLaboratorioWindow(null);
    }//GEN-LAST:event_jBCadastrarLaboratorioActionPerformed

    private void jBExcluirLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirLaboratorioActionPerformed
        if (jTLaboratorio.getSelectedRow() != -1) {
            LaboratorioDAO.delete(model.getLaboratorios().get(jTLaboratorio.getSelectedRow()));
            model.deleteLinha(jTLaboratorio.getSelectedRow());
        }
    }//GEN-LAST:event_jBExcluirLaboratorioActionPerformed

    private void loadTable() {
        jTLaboratorio.setModel(model);
        model.loadTable();
        jTLaboratorio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jTLaboratorio.setRowHeight(24);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(SwingConstants.CENTER);
        jTLaboratorio.getColumnModel().getColumn(1).setCellRenderer(centralizador);
        jTLaboratorio.getColumnModel().getColumn(2).setCellRenderer(centralizador);
        jTLaboratorio.getColumnModel().getColumn(5).setCellRenderer(centralizador);
        jTLaboratorio.getColumnModel().getColumn(8).setCellRenderer(centralizador);
    }

    private void openLaboratorioWindow(Laboratorio lab) {
        JFLaboratorio JFLaboratorio;
        if (lab != null) {
            JFLaboratorio = new JFLaboratorio(lab);
        } else {
            JFLaboratorio = new JFLaboratorio();
        }
        JFLaboratorio.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (JFLaboratorio.getResponse() == 1) {
                    Laboratorio labUpdated = JFLaboratorio.getLaboratorioUpdated();
                    model.setValueAt(labUpdated.getNumero(), jTLaboratorio.getSelectedRow(), 3);
                    model.setValueAt(labUpdated.getRua(), jTLaboratorio.getSelectedRow(), 4);
                    model.setValueAt(labUpdated.getCep(), jTLaboratorio.getSelectedRow(), 5);
                    model.setValueAt(labUpdated.getBairro(), jTLaboratorio.getSelectedRow(), 6);
                    model.setValueAt(labUpdated.getCidade(), jTLaboratorio.getSelectedRow(), 7);
                    model.setValueAt(labUpdated.getEstado(), jTLaboratorio.getSelectedRow(), 8);
                    model.setValueAt(labUpdated.getComplemento(), jTLaboratorio.getSelectedRow(), 9);
                    LaboratorioDAO.update(labUpdated);
                } else if (JFLaboratorio.getResponse() == 2) {
                    LaboratorioDAO.create(JFLaboratorio.getNewLaboratorio());
                    model.loadTable();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizarLaboratorio;
    private javax.swing.JButton jBCadastrarLaboratorio;
    private javax.swing.JButton jBExcluirLaboratorio;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<String> jCBTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFPesquisa;
    private javax.swing.JTable jTLaboratorio;
    // End of variables declaration//GEN-END:variables
}
