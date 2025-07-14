package com.mycompany.projetointegradordesktop.JFrame;

import com.mycompany.projetointegradordesktop.DAO.DrogariaDAO;
import com.mycompany.projetointegradordesktop.DAO.VendaDAO;
import com.mycompany.projetointegradordesktop.Model.VendaTableModel;
import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class IFVenda extends javax.swing.JInternalFrame {

    VendaTableModel model = new VendaTableModel();

    public IFVenda() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVenda = new javax.swing.JTable();
        jBExcluirVenda = new javax.swing.JButton();
        jBNovaVenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFPesquisa = new javax.swing.JTextField();
        jCBTipoPesquisa = new javax.swing.JComboBox<>();
        jBPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCBDrogaria = new javax.swing.JComboBox<>();
        jBCadastrarRemedio1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

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

        jCBTipoPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descrição", "Fornecedor" }));

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
        jLabel2.setText("Drogaria");

        jCBDrogaria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jBCadastrarRemedio1.setBackground(new java.awt.Color(0, 102, 204));
        jBCadastrarRemedio1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastrarRemedio1.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrarRemedio1.setText("Filtrar");
        jBCadastrarRemedio1.setBorder(null);
        jBCadastrarRemedio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarRemedio1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBCadastrarRemedio1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCBTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTFPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastrarRemedio1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 516, Short.MAX_VALUE)
                        .addComponent(jBNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBExcluirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBExcluirVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirVendaActionPerformed
        if (jTVenda.getSelectedRow() != -1) {
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

    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBCadastrarRemedio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarRemedio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCadastrarRemedio1ActionPerformed

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

    public void loadDrogarias() {
        jCBDrogaria.removeAllItems();
        Drogaria drogaria = new Drogaria();
        drogaria.setNome("Todas");
        jCBDrogaria.addItem(drogaria);
        for (Drogaria d : DrogariaDAO.read()) {
            jCBDrogaria.addItem(d);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrarRemedio1;
    private javax.swing.JButton jBExcluirVenda;
    private javax.swing.JButton jBNovaVenda;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<Drogaria> jCBDrogaria;
    private javax.swing.JComboBox<String> jCBTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFPesquisa;
    private javax.swing.JTable jTVenda;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
