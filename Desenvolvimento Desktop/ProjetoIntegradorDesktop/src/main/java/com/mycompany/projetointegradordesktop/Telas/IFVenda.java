package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.DAO.DrogariaDAO;
import com.mycompany.projetointegradordesktop.DAO.ItemDAO;
import com.mycompany.projetointegradordesktop.DAO.VendaDAO;
import com.mycompany.projetointegradordesktop.Model.VendaTableModel;
import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import com.mycompany.projetointegradordesktop.Util.FormatadorValor;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;

public class IFVenda extends javax.swing.JInternalFrame {

    VendaTableModel model = new VendaTableModel();

    public IFVenda() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
        loadDrogarias();
        loadOrdenar();
        loadCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTVenda = new javax.swing.JTable();
        jBExcluirVenda = new javax.swing.JButton();
        jBNovaVenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTFPesquisa = new javax.swing.JTextField();
        jBPesquisar = new javax.swing.JButton();
        jBFiltrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCBoxValorTotal = new javax.swing.JCheckBox();
        jPValorTotal = new javax.swing.JPanel();
        jLValorCustoMax5 = new javax.swing.JLabel();
        jLValorCustoMax = new javax.swing.JLabel();
        jFTFValorTotalMin = new javax.swing.JFormattedTextField();
        jFTFValorTotalMax = new javax.swing.JFormattedTextField();
        jLValorCustoMax1 = new javax.swing.JLabel();
        jCBOrdenar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCBoxDesc = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jCBDrogaria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCBPagamento = new javax.swing.JComboBox<>();

        setBorder(null);

        jTVenda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTVenda);

        jBExcluirVenda.setBackground(new java.awt.Color(153, 51, 0));
        jBExcluirVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBExcluirVenda.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluirVenda.setText("Excluir Venda");
        jBExcluirVenda.setBorder(null);
        jBExcluirVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirVendaActionPerformed(evt);
            }
        });

        jBNovaVenda.setBackground(new java.awt.Color(51, 90, 15));
        jBNovaVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBNovaVenda.setForeground(new java.awt.Color(255, 255, 255));
        jBNovaVenda.setText("Nova Venda");
        jBNovaVenda.setBorder(null);
        jBNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovaVendaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Vendas");

        jTFPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        jBFiltrar.setBackground(new java.awt.Color(0, 102, 204));
        jBFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        jBFiltrar.setText("Filtrar");
        jBFiltrar.setBorder(null);
        jBFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFiltrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("N° NF");

        jCBoxValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBoxValorTotal.setText("Ativar");
        jCBoxValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxValorTotalActionPerformed(evt);
            }
        });

        jLValorCustoMax5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax5.setText("Min.");

        jLValorCustoMax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax.setText("Valor Total");

        jFTFValorTotalMin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jFTFValorTotalMax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLValorCustoMax1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax1.setText("Máx.");

        javax.swing.GroupLayout jPValorTotalLayout = new javax.swing.GroupLayout(jPValorTotal);
        jPValorTotal.setLayout(jPValorTotalLayout);
        jPValorTotalLayout.setHorizontalGroup(
            jPValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValorTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLValorCustoMax)
                .addGap(25, 25, 25)
                .addComponent(jLValorCustoMax5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValorTotalMin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLValorCustoMax1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValorTotalMax, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPValorTotalLayout.setVerticalGroup(
            jPValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValorTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValorCustoMax)
                    .addComponent(jFTFValorTotalMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFValorTotalMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValorCustoMax1)
                    .addComponent(jLValorCustoMax5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCBOrdenar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Ordenar por");

        jCBoxDesc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBoxDesc.setText("Decrescente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Drogaria");

        jCBDrogaria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Pagamento");

        jCBPagamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pix", "Débito", "Crédito", "Cheque", "Boleto" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCBoxDesc))
                                .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jPValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jCBoxValorTotal)
                            .addGap(6, 6, 6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCBDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jCBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(377, 377, 377))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jCBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jCBoxValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBoxDesc))
                .addGap(12, 12, 12)
                .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBExcluirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBExcluirVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirVendaActionPerformed
        if (jTVenda.getSelectedRow() != -1) {
            ItemDAO.deleteVendas(model.getVendas().get(jTVenda.getSelectedRow()));
            VendaDAO.delete(model.getVendas().get(jTVenda.getSelectedRow()));
            model.deleteLinha(jTVenda.getSelectedRow());
        }
    }//GEN-LAST:event_jBExcluirVendaActionPerformed

    private void jBNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovaVendaActionPerformed
        IFNovaVenda IFNovaVenda = new IFNovaVenda();
        IFNovaVenda.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                model.loadTable();
            }
        });
        IFNovaVenda.setSize(getDesktopPane().getSize());
        getDesktopPane().add(IFNovaVenda);
        IFNovaVenda.toFront();
    }//GEN-LAST:event_jBNovaVendaActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        model.setVendas(VendaDAO.read(jTFPesquisa.getText()));
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFiltrarActionPerformed
        String nNF = jTFPesquisa.getText();
        Drogaria d = null;
        String pagamento = null;
        double valorTotalMin = 0;
        double valorTotalMax = 10000;
        String orderBy = null;
        boolean desc = false;

        if (jCBDrogaria.getSelectedIndex() != 0) {
            d = (Drogaria) jCBDrogaria.getSelectedItem();
        }
        if (jCBPagamento.getSelectedIndex() != 0) {
            pagamento = jCBPagamento.getSelectedItem().toString();
        }
        if (jCBoxValorTotal.isSelected()) {
            valorTotalMin = ((Number) jFTFValorTotalMin.getValue()).doubleValue();
            valorTotalMax = ((Number) jFTFValorTotalMax.getValue()).doubleValue();
        }
        if (jCBOrdenar.getSelectedIndex() != 0) {
            orderBy = getOrdenar();
        }
        if (jCBoxDesc.isSelected()) {
            desc = true;
        }
        System.out.println(jCBPagamento.getSelectedItem().toString());
        model.setVendas(VendaDAO.readDinamico(nNF, d, pagamento, valorTotalMin, valorTotalMax, orderBy, desc));
    }//GEN-LAST:event_jBFiltrarActionPerformed

    private void jCBoxValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxValorTotalActionPerformed
        if (jCBoxValorTotal.isSelected()) {
            for (Component comp : jPValorTotal.getComponents()) {
                comp.setEnabled(true);
            }
        } else {
            for (Component comp : jPValorTotal.getComponents()) {
                comp.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jCBoxValorTotalActionPerformed

    private void loadTable() {
        jTVenda.setModel(model);
        model.loadTable();
        jTVenda.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jTVenda.setRowHeight(24);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(SwingConstants.CENTER);
        jTVenda.getColumnModel().getColumn(1).setCellRenderer(centralizador);
        jTVenda.getColumnModel().getColumn(2).setCellRenderer(centralizador);
        jTVenda.getColumnModel().getColumn(3).setCellRenderer(centralizador);
        jTVenda.getColumnModel().getColumn(4).setCellRenderer(centralizador);
    }
    
    private void loadCampos() {
        for (Component comp : jPValorTotal.getComponents()) {
            comp.setEnabled(false);
        }
        for (Component comp : jPValorTotal.getComponents()) {
            comp.setEnabled(false);
        }
        FormatadorValor.formatarCampo(jFTFValorTotalMin);
        jFTFValorTotalMin.setValue(0);
        FormatadorValor.formatarCampo(jFTFValorTotalMax);
        jFTFValorTotalMax.setValue(10000);
    }

    public void loadDrogarias() {
        jCBDrogaria.removeAllItems();
        Drogaria drogaria = new Drogaria();
        drogaria.setNome("Todas");
        jCBDrogaria.addItem(drogaria);
        for (Drogaria d : DrogariaDAO.read()) {
            jCBDrogaria.addItem(d);
        }
    }
    
    private void loadOrdenar() {
        jCBOrdenar.removeAllItems();
        jCBOrdenar.addItem("Nenhum");
        for (String coluna : model.getColunas()) {
            jCBOrdenar.addItem(coluna);
        }
    }

    private String getOrdenar() {
        switch (jCBOrdenar.getSelectedIndex()) {
            case 1:
                return "id_drog";
            case 2:
                return "data_venda";
            case 3:
                return "data_entrega";
            case 4:
                return "nmr_nota_fiscal";
            case 5:
                return "total_nota";
            case 6:
                return "forma_pagamento";
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluirVenda;
    private javax.swing.JButton jBFiltrar;
    private javax.swing.JButton jBNovaVenda;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<Drogaria> jCBDrogaria;
    private javax.swing.JComboBox<String> jCBOrdenar;
    private javax.swing.JComboBox<String> jCBPagamento;
    private javax.swing.JCheckBox jCBoxDesc;
    private javax.swing.JCheckBox jCBoxValorTotal;
    private javax.swing.JFormattedTextField jFTFValorTotalMax;
    private javax.swing.JFormattedTextField jFTFValorTotalMin;
    private javax.swing.JLabel jLValorCustoMax;
    private javax.swing.JLabel jLValorCustoMax1;
    private javax.swing.JLabel jLValorCustoMax5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPValorTotal;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFPesquisa;
    private javax.swing.JTable jTVenda;
    // End of variables declaration//GEN-END:variables
}
