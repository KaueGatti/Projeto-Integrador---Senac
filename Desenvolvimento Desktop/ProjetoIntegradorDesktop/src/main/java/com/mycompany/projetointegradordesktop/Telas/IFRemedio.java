package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.DAO.LaboratorioDAO;
import com.mycompany.projetointegradordesktop.DAO.RemedioDAO;
import com.mycompany.projetointegradordesktop.Model.RemedioTableModel;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import com.mycompany.projetointegradordesktop.Util.FormatadorValor;
import java.awt.Component;
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
        loadLaboratorios();
        loadCampos();
        loadOrdenar();
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
        jBPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCBLaboratorio = new javax.swing.JComboBox<>();
        jBFiltrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCBoxValorCusto = new javax.swing.JCheckBox();
        jCBoxValorVenda = new javax.swing.JCheckBox();
        jPValorCusto = new javax.swing.JPanel();
        jLValorCustoMax5 = new javax.swing.JLabel();
        jLValorCustoMax = new javax.swing.JLabel();
        jFTFValorCustoMin = new javax.swing.JFormattedTextField();
        jFTFValorCustoMax = new javax.swing.JFormattedTextField();
        jLValorCustoMax1 = new javax.swing.JLabel();
        jPValorVenda = new javax.swing.JPanel();
        jLValorCustoMax2 = new javax.swing.JLabel();
        jLValorCustoMax4 = new javax.swing.JLabel();
        jFTFValorVendaMin = new javax.swing.JFormattedTextField();
        jLValorCustoMax3 = new javax.swing.JLabel();
        jFTFValorVendaMax = new javax.swing.JFormattedTextField();
        jCBOrdenar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jCBoxDesc = new javax.swing.JCheckBox();

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Laboratório");

        jCBLaboratorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Descrição");

        jCBoxValorCusto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBoxValorCusto.setText("Ativar");
        jCBoxValorCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxValorCustoActionPerformed(evt);
            }
        });

        jCBoxValorVenda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBoxValorVenda.setText("Ativar");
        jCBoxValorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxValorVendaActionPerformed(evt);
            }
        });

        jLValorCustoMax5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax5.setText("Min.");

        jLValorCustoMax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax.setText("Valor de Custo");

        jFTFValorCustoMin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jFTFValorCustoMax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLValorCustoMax1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax1.setText("Máx.");

        javax.swing.GroupLayout jPValorCustoLayout = new javax.swing.GroupLayout(jPValorCusto);
        jPValorCusto.setLayout(jPValorCustoLayout);
        jPValorCustoLayout.setHorizontalGroup(
            jPValorCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValorCustoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLValorCustoMax)
                .addGap(25, 25, 25)
                .addComponent(jLValorCustoMax5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValorCustoMin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLValorCustoMax1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValorCustoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPValorCustoLayout.setVerticalGroup(
            jPValorCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValorCustoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPValorCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValorCustoMax)
                    .addComponent(jFTFValorCustoMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFValorCustoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValorCustoMax1)
                    .addComponent(jLValorCustoMax5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLValorCustoMax2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax2.setText("Valor de Venda");

        jLValorCustoMax4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax4.setText("Min.");

        jFTFValorVendaMin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLValorCustoMax3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax3.setText("Máx.");

        jFTFValorVendaMax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPValorVendaLayout = new javax.swing.GroupLayout(jPValorVenda);
        jPValorVenda.setLayout(jPValorVendaLayout);
        jPValorVendaLayout.setHorizontalGroup(
            jPValorVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValorVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLValorCustoMax2)
                .addGap(18, 18, 18)
                .addComponent(jLValorCustoMax4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValorVendaMin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLValorCustoMax3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValorVendaMax, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPValorVendaLayout.setVerticalGroup(
            jPValorVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValorVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPValorVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValorCustoMax2)
                    .addComponent(jLValorCustoMax4)
                    .addComponent(jFTFValorVendaMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValorCustoMax3)
                    .addComponent(jFTFValorVendaMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCBOrdenar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Ordenar por");

        jCBoxDesc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBoxDesc.setText("Decrescente");
        jCBoxDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxDescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBoxValorCusto))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBoxValorVenda))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCBoxDesc))
                                    .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jCBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCBoxValorCusto)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jCBoxValorVenda))
                    .addComponent(jPValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBCadastrarRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBExcluirRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAtualizarRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
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
            int response = RemedioDAO.delete(model.getRemedios().get(jTRemedio.getSelectedRow()));
            if (response == 1) {
                model.deleteLinha(jTRemedio.getSelectedRow());
            }
        }
    }//GEN-LAST:event_jBExcluirRemedioActionPerformed

    private void jBAtualizarRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarRemedioActionPerformed
        if (jTRemedio.getSelectedRow() != -1) {
            Remedio remedio = model.getRemedios().get(jTRemedio.getSelectedRow());
            openRemedioWindow(remedio);
        }
    }//GEN-LAST:event_jBAtualizarRemedioActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        model.setRemedios(RemedioDAO.read(jTFPesquisa.getText()));
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFiltrarActionPerformed
        boolean filterLab = jCBLaboratorio.getSelectedIndex() != 0;
        boolean filterValorCusto = jCBoxValorCusto.isSelected();
        boolean filterValorVenda = jCBoxValorVenda.isSelected();

        String descricao = jTFPesquisa.getText();
        Laboratorio l = null;
        double valorCustoMin = 0;
        double valorCustoMax = 1000;
        double valorVendaMin = 0;
        double valorVendaMax = 1000;
        String orderBy = null;
        boolean desc = false;
        if (filterLab) {
            l = (Laboratorio) jCBLaboratorio.getSelectedItem();
        }
        if (filterValorCusto) {
            valorCustoMin = ((Number) jFTFValorCustoMin.getValue()).doubleValue();
            valorCustoMax = ((Number) jFTFValorCustoMax.getValue()).doubleValue();
        }
        if (filterValorVenda) {
            valorVendaMin = ((Number) jFTFValorVendaMin.getValue()).doubleValue();
            valorVendaMax = ((Number) jFTFValorVendaMax.getValue()).doubleValue();
        }
        if (jCBOrdenar.getSelectedIndex() != 0) {
            orderBy = getOrdenar();
        }
        if (jCBoxDesc.isSelected()) {
            desc = true;
        }
        model.setRemedios(RemedioDAO.readDinamico(descricao, l, valorCustoMin, valorCustoMax, valorVendaMin, valorVendaMax, orderBy, desc));
    }//GEN-LAST:event_jBFiltrarActionPerformed

    private void jCBoxValorCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxValorCustoActionPerformed
        if (jCBoxValorCusto.isSelected()) {
            for (Component comp : jPValorCusto.getComponents()) {
                comp.setEnabled(true);
            }
        } else {
            for (Component comp : jPValorCusto.getComponents()) {
                comp.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jCBoxValorCustoActionPerformed

    private void jCBoxValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxValorVendaActionPerformed
        if (jCBoxValorVenda.isSelected()) {

            for (Component comp : jPValorVenda.getComponents()) {
                comp.setEnabled(true);
            }
        } else {
            for (Component comp : jPValorVenda.getComponents()) {
                comp.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jCBoxValorVendaActionPerformed

    private void jCBoxDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxDescActionPerformed

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

    public void loadLaboratorios() {
        jCBLaboratorio.removeAllItems();
        Laboratorio l = new Laboratorio();
        l.setNome("Todos");
        jCBLaboratorio.addItem(l);
        for (Laboratorio lab : LaboratorioDAO.read()) {
            jCBLaboratorio.addItem(lab);
        }
    }

    private void loadCampos() {
        for (Component comp : jPValorCusto.getComponents()) {
            comp.setEnabled(false);
        }
        for (Component comp : jPValorVenda.getComponents()) {
            comp.setEnabled(false);
        }
        FormatadorValor.formatarCampo(jFTFValorCustoMin);
        jFTFValorCustoMin.setValue(0);
        FormatadorValor.formatarCampo(jFTFValorCustoMax);
        jFTFValorCustoMax.setValue(100);
        FormatadorValor.formatarCampo(jFTFValorVendaMin);
        jFTFValorVendaMin.setValue(0);
        FormatadorValor.formatarCampo(jFTFValorVendaMax);
        jFTFValorVendaMax.setValue(100);
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
                return "id_lab";
            case 2:
                return "descricao";
            case 3:
                return "data_ultima_compra";
            case 4:
                return "valor_custo";
            case 5:
                return "valor_venda";
            case 6:
                return "qntd_armazenada";
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizarRemedio;
    private javax.swing.JButton jBCadastrarRemedio;
    private javax.swing.JButton jBExcluirRemedio;
    private javax.swing.JButton jBFiltrar;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<Laboratorio> jCBLaboratorio;
    private javax.swing.JComboBox<String> jCBOrdenar;
    private javax.swing.JCheckBox jCBoxDesc;
    private javax.swing.JCheckBox jCBoxValorCusto;
    private javax.swing.JCheckBox jCBoxValorVenda;
    private javax.swing.JFormattedTextField jFTFValorCustoMax;
    private javax.swing.JFormattedTextField jFTFValorCustoMin;
    private javax.swing.JFormattedTextField jFTFValorVendaMax;
    private javax.swing.JFormattedTextField jFTFValorVendaMin;
    private javax.swing.JLabel jLValorCustoMax;
    private javax.swing.JLabel jLValorCustoMax1;
    private javax.swing.JLabel jLValorCustoMax2;
    private javax.swing.JLabel jLValorCustoMax3;
    private javax.swing.JLabel jLValorCustoMax4;
    private javax.swing.JLabel jLValorCustoMax5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPValorCusto;
    private javax.swing.JPanel jPValorVenda;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFPesquisa;
    private javax.swing.JTable jTRemedio;
    // End of variables declaration//GEN-END:variables
}
