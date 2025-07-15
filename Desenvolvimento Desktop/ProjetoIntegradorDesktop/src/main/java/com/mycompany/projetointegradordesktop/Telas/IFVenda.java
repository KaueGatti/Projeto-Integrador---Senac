package com.mycompany.projetointegradordesktop.Telas;

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

public class IFVenda extends javax.swing.JInternalFrame {

    VendaTableModel model = new VendaTableModel();

    public IFVenda() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
        loadDrogarias();
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
        jLabel2 = new javax.swing.JLabel();
        jCBDrogaria = new javax.swing.JComboBox<>();
        jBFiltrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCBPagamento = new javax.swing.JComboBox<>();

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Drogaria");

        jCBDrogaria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
        jLabel3.setText("Pagamento");

        jCBPagamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pix", "Débito", "Crédito", "Cheque", "Boleto" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jCBDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jCBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jCBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
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

    private void jBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFiltrarActionPerformed
        if (jCBDrogaria.getSelectedIndex() == 0 && jCBPagamento.getSelectedIndex()== 0) {
            model.setVendas(VendaDAO.read());       
        } else if (jCBDrogaria.getSelectedIndex() == 0) {
            model.setVendas(VendaDAO.read(jCBPagamento.getSelectedItem().toString()));
        } else if (jCBPagamento.getSelectedIndex() == 0) {
            model.setVendas(VendaDAO.read((Drogaria) jCBDrogaria.getSelectedItem()));
        } else {
            model.setVendas(VendaDAO.read((Drogaria) jCBDrogaria.getSelectedItem(), jCBPagamento.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_jBFiltrarActionPerformed

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
    private javax.swing.JButton jBExcluirVenda;
    private javax.swing.JButton jBFiltrar;
    private javax.swing.JButton jBNovaVenda;
    private javax.swing.JComboBox<Drogaria> jCBDrogaria;
    private javax.swing.JComboBox<String> jCBPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTVenda;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
