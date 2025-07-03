package com.mycompany.projetointegradordesktop.JFrame;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.projetointegradordesktop.DB.Conexao;
import java.awt.Component;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        System.out.println(jDesktopPane1.getSize().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBMenu = new javax.swing.JButton();
        jBRemedio = new javax.swing.JButton();
        jBDrogaria = new javax.swing.JButton();
        jBVenda = new javax.swing.JButton();
        jBLaboratorio = new javax.swing.JButton();
        jBCompra = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 90, 15));
        jPanel1.setForeground(new java.awt.Color(51, 90, 15));

        jBMenu.setBackground(new java.awt.Color(51, 90, 15));
        jBMenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jBMenu.setForeground(new java.awt.Color(255, 255, 255));
        jBMenu.setText("Menu");
        jBMenu.setBorder(null);
        jBMenu.setBorderPainted(false);
        jBMenu.setIconTextGap(60);
        jBMenu.setMargin(new java.awt.Insets(10, 14, 3, 50));
        jBMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMenuActionPerformed(evt);
            }
        });

        jBRemedio.setBackground(new java.awt.Color(51, 90, 15));
        jBRemedio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jBRemedio.setForeground(new java.awt.Color(255, 255, 255));
        jBRemedio.setText("Remédios");
        jBRemedio.setBorder(null);
        jBRemedio.setBorderPainted(false);
        jBRemedio.setIconTextGap(60);
        jBRemedio.setMargin(new java.awt.Insets(10, 14, 3, 50));
        jBRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemedioActionPerformed(evt);
            }
        });

        jBDrogaria.setBackground(new java.awt.Color(51, 90, 15));
        jBDrogaria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jBDrogaria.setForeground(new java.awt.Color(255, 255, 255));
        jBDrogaria.setText("Drogarias");
        jBDrogaria.setBorder(null);
        jBDrogaria.setBorderPainted(false);
        jBDrogaria.setIconTextGap(60);
        jBDrogaria.setMargin(new java.awt.Insets(10, 14, 3, 50));
        jBDrogaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDrogariaActionPerformed(evt);
            }
        });

        jBVenda.setBackground(new java.awt.Color(51, 90, 15));
        jBVenda.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jBVenda.setForeground(new java.awt.Color(255, 255, 255));
        jBVenda.setText("Vendas");
        jBVenda.setBorder(null);
        jBVenda.setBorderPainted(false);
        jBVenda.setIconTextGap(60);
        jBVenda.setMargin(new java.awt.Insets(10, 14, 3, 50));
        jBVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVendaActionPerformed(evt);
            }
        });

        jBLaboratorio.setBackground(new java.awt.Color(51, 90, 15));
        jBLaboratorio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jBLaboratorio.setForeground(new java.awt.Color(255, 255, 255));
        jBLaboratorio.setText("Laboratórios");
        jBLaboratorio.setBorder(null);
        jBLaboratorio.setBorderPainted(false);
        jBLaboratorio.setIconTextGap(60);
        jBLaboratorio.setMargin(new java.awt.Insets(10, 14, 3, 50));
        jBLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLaboratorioActionPerformed(evt);
            }
        });

        jBCompra.setBackground(new java.awt.Color(51, 90, 15));
        jBCompra.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jBCompra.setForeground(new java.awt.Color(255, 255, 255));
        jBCompra.setText("Compras");
        jBCompra.setBorder(null);
        jBCompra.setBorderPainted(false);
        jBCompra.setIconTextGap(60);
        jBCompra.setMargin(new java.awt.Insets(10, 14, 3, 50));
        jBCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBDrogaria, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
            .addComponent(jBLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
            .addComponent(jBVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBRemedio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jBMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1844, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMenuActionPerformed
        closeIF();
        Conexao.getConnection();
    }//GEN-LAST:event_jBMenuActionPerformed

    private void jBRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemedioActionPerformed
        closeIF();
        IFRemedio IFRemedio = new IFRemedio();
        IFRemedio.setSize(jDesktopPane1.getSize());
        jDesktopPane1.add(IFRemedio);
    }//GEN-LAST:event_jBRemedioActionPerformed

    private void jBDrogariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDrogariaActionPerformed
        closeIF();
        IFDrogaria IFDrogaria = new IFDrogaria();
        IFDrogaria.setSize(jDesktopPane1.getSize());
        jDesktopPane1.add(IFDrogaria);
    }//GEN-LAST:event_jBDrogariaActionPerformed

    private void jBVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVendaActionPerformed
        closeIF();
        IFVenda IFVenda = new IFVenda();
        IFVenda.setSize(jDesktopPane1.getSize());
        jDesktopPane1.add(IFVenda);
    }//GEN-LAST:event_jBVendaActionPerformed

    private void jBLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLaboratorioActionPerformed
        closeIF();
        IFLaboratorio IFLaboratorio = new IFLaboratorio();
        IFLaboratorio.setSize(jDesktopPane1.getSize());
        jDesktopPane1.add(IFLaboratorio);
    }//GEN-LAST:event_jBLaboratorioActionPerformed

    private void jBCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCompraActionPerformed
        closeIF();
        IFCompra IFCompra = new IFCompra(jDesktopPane1);
        IFCompra.setSize(jDesktopPane1.getSize());
        jDesktopPane1.add(IFCompra);
    }//GEN-LAST:event_jBCompraActionPerformed

    public void closeIF() {
        for (Component comp : jDesktopPane1.getComponents()) {
            if (comp instanceof JInternalFrame IF) {
                try {
                    IF.setClosed(true);
                } catch (PropertyVetoException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar IF: " + ex);
                }
            }
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (Exception e) {
                }
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCompra;
    private javax.swing.JButton jBDrogaria;
    private javax.swing.JButton jBLaboratorio;
    private javax.swing.JButton jBMenu;
    private javax.swing.JButton jBRemedio;
    private javax.swing.JButton jBVenda;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
