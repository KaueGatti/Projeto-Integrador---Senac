package com.mycompany.projetointegradordesktop.JFrame;

import com.mycompany.projetointegradordesktop.DAO.CompraDAO;
import com.mycompany.projetointegradordesktop.Model.CompraTableModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;

public class IFCompra extends javax.swing.JInternalFrame {

    CompraTableModel model = new CompraTableModel();

    public IFCompra() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
        jTCompra.setModel(model);
        model.loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTCompra = new javax.swing.JTable();
        jBExcluirCompra = new javax.swing.JButton();
        jBNovaCompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFPesquisa = new javax.swing.JTextField();
        jCBTipoPesquisa = new javax.swing.JComboBox<>();
        jBPesquisar = new javax.swing.JButton();

        setBorder(null);

        jTCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jTCompra.setMaximumSize(new java.awt.Dimension(100, 80));
        jScrollPane1.setViewportView(jTCompra);

        jBExcluirCompra.setBackground(new java.awt.Color(153, 51, 0));
        jBExcluirCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBExcluirCompra.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluirCompra.setText("Excluir Compra");
        jBExcluirCompra.setBorder(null);
        jBExcluirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirCompraActionPerformed(evt);
            }
        });

        jBNovaCompra.setBackground(new java.awt.Color(51, 90, 15));
        jBNovaCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBNovaCompra.setForeground(new java.awt.Color(255, 255, 255));
        jBNovaCompra.setText("Nova Compra");
        jBNovaCompra.setBorder(null);
        jBNovaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovaCompraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Compras");

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 488, Short.MAX_VALUE)
                        .addComponent(jBNovaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBNovaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBExcluirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBExcluirCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirCompraActionPerformed
        if (jTCompra.getSelectedRow() != -1) {
            CompraDAO.delete(model.getCompras().get(jTCompra.getSelectedRow()));
            model.deleteLinha(jTCompra.getSelectedRow());
        }
    }//GEN-LAST:event_jBExcluirCompraActionPerformed

    private void jBNovaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovaCompraActionPerformed
        IFNovaCompra IFNovaCompra = new IFNovaCompra();
        IFNovaCompra.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                model.loadTable();
            }
        }
        );
        IFNovaCompra.setSize(getDesktopPane().getSize());
        getDesktopPane().add(IFNovaCompra);
        IFNovaCompra.toFront();
    }//GEN-LAST:event_jBNovaCompraActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        System.out.println(this.getDesktopPane());
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void loadTable() {
        jTCompra.setModel(model);
        model.loadTable();
        jTCompra.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jTCompra.setRowHeight(24);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(SwingConstants.CENTER);
        jTCompra.getColumnModel().getColumn(1).setCellRenderer(centralizador);
        jTCompra.getColumnModel().getColumn(2).setCellRenderer(centralizador);
        jTCompra.getColumnModel().getColumn(3).setCellRenderer(centralizador);
        jTCompra.getColumnModel().getColumn(4).setCellRenderer(centralizador);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluirCompra;
    private javax.swing.JButton jBNovaCompra;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<String> jCBTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCompra;
    private javax.swing.JTextField jTFPesquisa;
    // End of variables declaration//GEN-END:variables
}
