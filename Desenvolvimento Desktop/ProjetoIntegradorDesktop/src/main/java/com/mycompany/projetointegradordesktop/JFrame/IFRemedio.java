package com.mycompany.projetointegradordesktop.JFrame;

import com.mycompany.projetointegradordesktop.DAO.RemedioDAO;
import com.mycompany.projetointegradordesktop.Model.RemedioTableModel;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import java.awt.Component;
import javax.swing.JTextField;

public class IFRemedio extends javax.swing.JInternalFrame {

    RemedioTableModel model = new RemedioTableModel();

    public IFRemedio() {
        initComponents();
        setVisible(true);
        jTRemedio.setModel(model);
        model.loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTRemedio = new javax.swing.JTable();
        jPCadastro = new javax.swing.JPanel();
        jTFDescricao = new javax.swing.JTextField();
        jTFValorCusto = new javax.swing.JTextField();
        jTFValorVenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBCadastrar = new javax.swing.JButton();
        jBAtualizar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jCBLaboratorio = new javax.swing.JComboBox<>();
        jPPesquisa = new javax.swing.JPanel();
        jTFPesquisa = new javax.swing.JTextField();
        jBPesquisar = new javax.swing.JButton();
        jCBTipoPesquisa = new javax.swing.JComboBox<>();

        setBorder(null);
        setMaximizable(true);

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

        jPCadastro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Descrição");

        jLabel4.setText("Valor Custo");

        jLabel6.setText("Valor Venda");

        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jBAtualizar.setText("Atualizar");
        jBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jLabel7.setText("Laboratório");

        jCBLaboratorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPCadastroLayout = new javax.swing.GroupLayout(jPCadastro);
        jPCadastro.setLayout(jPCadastroLayout);
        jPCadastroLayout.setHorizontalGroup(
            jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jCBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPCadastroLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jBAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPCadastroLayout.createSequentialGroup()
                            .addGroup(jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPCadastroLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(22, 22, 22))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCadastroLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPCadastroLayout.createSequentialGroup()
                                    .addComponent(jTFValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTFValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPCadastroLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(45, 45, 45))
        );
        jPCadastroLayout.setVerticalGroup(
            jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCadastroLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrar)
                    .addComponent(jBAtualizar)
                    .addComponent(jBExcluir))
                .addGap(15, 15, 15))
        );

        jPPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jBPesquisar.setText("Pesquisar");

        jCBTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPPesquisaLayout = new javax.swing.GroupLayout(jPPesquisa);
        jPPesquisa.setLayout(jPPesquisaLayout);
        jPPesquisaLayout.setHorizontalGroup(
            jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBTipoPesquisa, 0, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBPesquisar)
                .addGap(14, 14, 14))
        );
        jPPesquisaLayout.setVerticalGroup(
            jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPesquisaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar)
                    .addComponent(jCBTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        Remedio remedio = new Remedio();
        
        Laboratorio labTest = new Laboratorio();
        labTest.setId(1);
        remedio.setLaboratorio(labTest);
        remedio.setDescricao(jTFDescricao.getText());
        remedio.setValorCusto(Double.parseDouble(jTFValorCusto.getText()));
        remedio.setValorVenda(Double.parseDouble(jTFValorVenda.getText()));
        RemedioDAO.create(remedio);
        model.loadTable();

        limpaCampos();

        jTFDescricao.requestFocus();
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if (jTRemedio.getSelectedRow() != -1) {
            RemedioDAO.delete(model.getRemedios().get(jTRemedio.getSelectedRow()));
            model.deleteLinha(jTRemedio.getSelectedRow());
        }
        limpaCampos();
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarActionPerformed
        if (jTRemedio.getSelectedRow() != -1) {
            model.setValueAt(jTFDescricao.getText(), jTRemedio.getSelectedRow(), 1);
            model.setValueAt(jTFValorCusto.getText(), jTRemedio.getSelectedRow(), 3);
            model.setValueAt(jTFValorVenda.getText(), jTRemedio.getSelectedRow(), 4);
            RemedioDAO.update(model.getRemedios().get(jTRemedio.getSelectedRow()));
        }
    }//GEN-LAST:event_jBAtualizarActionPerformed

    private void jTRemedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRemedioMouseClicked
        if (jTRemedio.getSelectedRow() != -1) {
            jTFDescricao.setText(model.getValueAt(jTRemedio.getSelectedRow(), 1).toString());
            jTFValorCusto.setText(model.getValueAt(jTRemedio.getSelectedRow(), 3).toString());
            jTFValorVenda.setText(model.getValueAt(jTRemedio.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_jTRemedioMouseClicked

    public void limpaCampos() {
        for (Component comp : jPCadastro.getComponents()) {
            if (comp instanceof JTextField jTF) {
                jTF.setText("");
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizar;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<String> jCBLaboratorio;
    private javax.swing.JComboBox<String> jCBTipoPesquisa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPCadastro;
    private javax.swing.JPanel jPPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFPesquisa;
    private javax.swing.JTextField jTFValorCusto;
    private javax.swing.JTextField jTFValorVenda;
    private javax.swing.JTable jTRemedio;
    // End of variables declaration//GEN-END:variables
}
