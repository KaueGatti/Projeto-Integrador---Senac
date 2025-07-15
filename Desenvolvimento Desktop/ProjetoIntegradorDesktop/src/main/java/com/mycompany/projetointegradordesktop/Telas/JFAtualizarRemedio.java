package com.mycompany.projetointegradordesktop.Telas;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import com.mycompany.projetointegradordesktop.Util.FormatadorValor;
import java.util.function.Consumer;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JFAtualizarRemedio extends javax.swing.JFrame {

    private Remedio remedioUpdated;
    private int response;
    
    public JFAtualizarRemedio(Remedio remedio) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        remedioUpdated = remedio;
        loadCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jTFLab = new javax.swing.JTextField();
        jTFDescricao = new javax.swing.JTextField();
        jTFUltCompra = new javax.swing.JTextField();
        jFTFValorCusto = new javax.swing.JFormattedTextField();
        jFTFValorVenda = new javax.swing.JFormattedTextField();
        jTFQntdEstoque = new javax.swing.JTextField();
        jLInfoValorCusto = new javax.swing.JLabel();
        jLInfoValorVenda = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLInfoDescricao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Laboratório");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Descrição");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Data Últ. Compra");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Valor de Custo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Valor de Venda");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Quantidade em estoque");

        jBSalvar.setBackground(new java.awt.Color(51, 91, 15));
        jBSalvar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jBCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jTFLab.setEditable(false);
        jTFLab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFLab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFLab.setEnabled(false);

        jTFDescricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFDescricao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFDescricaoFocusLost(evt);
            }
        });

        jTFUltCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFUltCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFUltCompra.setEnabled(false);

        jFTFValorCusto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFValorCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFValorCustoFocusLost(evt);
            }
        });

        jFTFValorVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFValorVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFValorVendaFocusLost(evt);
            }
        });

        jTFQntdEstoque.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFQntdEstoque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFQntdEstoque.setEnabled(false);

        jLInfoValorCusto.setForeground(new java.awt.Color(204, 51, 0));
        jLInfoValorCusto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLInfoValorVenda.setForeground(new java.awt.Color(204, 51, 0));
        jLInfoValorVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Atualização de Remédio");

        jLInfoDescricao.setForeground(new java.awt.Color(204, 51, 0));
        jLInfoDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLInfoValorCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFLab)
                            .addComponent(jTFDescricao)
                            .addComponent(jTFUltCompra)
                            .addComponent(jFTFValorCusto)
                            .addComponent(jFTFValorVenda)
                            .addComponent(jTFQntdEstoque)
                            .addComponent(jLInfoValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLInfoDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)))
                .addGap(29, 29, 29))
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLInfoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFUltCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFTFValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLInfoValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFTFValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLInfoValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFQntdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        boolean descricaoIsValid = validarDescricao();
        boolean valorCustoIsValid = validarCampoNumerico(jFTFValorCusto, jLInfoValorCusto, remedioUpdated::setValorCusto);
        boolean valorVendaIsValid = validarCampoNumerico(jFTFValorVenda, jLInfoValorVenda, remedioUpdated::setValorVenda);
        if (descricaoIsValid && valorCustoIsValid && valorVendaIsValid) {
            response = 1;
            dispose();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private boolean validarCampoNumerico(JFormattedTextField campo, JLabel erro, Consumer<Double> setter) {
        Object valueCampo = campo.getValue();
        if (valueCampo != null && valueCampo instanceof Number) {
            double value = ((Number) valueCampo).doubleValue();
            if (value > 0) {
                setter.accept(value);
                erro.setText("");
                return true;
            } else {
                erro.setText("Valor inválido");
                return false;
            }
        } else {
            erro.setText("Defina um Valor");
            return false;
        }
    }

    private boolean validarDescricao() {
        String descricao = jTFDescricao.getText();
        if (!descricao.equals("")) {
            remedioUpdated.setDescricao(descricao);
            jLInfoDescricao.setText("");
            return true;
        } else {
            jLInfoDescricao.setText("Defina uma descrição");
            return false;
        }
    }

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        response = 0;
        dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTFDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFDescricaoFocusLost
        validarDescricao();
    }//GEN-LAST:event_jTFDescricaoFocusLost

    private void jFTFValorCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorCustoFocusLost
        validarCampoNumerico(jFTFValorCusto, jLInfoValorCusto, remedioUpdated::setValorCusto);
    }//GEN-LAST:event_jFTFValorCustoFocusLost

    private void jFTFValorVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorVendaFocusLost
        validarCampoNumerico(jFTFValorVenda, jLInfoValorVenda, remedioUpdated::setValorVenda);
    }//GEN-LAST:event_jFTFValorVendaFocusLost

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFAtualizarRemedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAtualizarRemedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAtualizarRemedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAtualizarRemedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                new JFAtualizarRemedio(new Remedio()).setVisible(true);
            }
        });
    }

    public void loadCampos() {
        FormatadorValor.formatarCampo(jFTFValorCusto);
        FormatadorValor.formatarCampo(jFTFValorVenda);
        jFTFValorCusto.setFont(jTFDescricao.getFont());
        jFTFValorVenda.setFont(jTFDescricao.getFont());
        jTFLab.setText(remedioUpdated.getLaboratorio().getNome());
        jTFDescricao.setText(remedioUpdated.getDescricao());
        if (remedioUpdated.getDataUltimaCompra() != null) {
            jTFUltCompra.setText(remedioUpdated.getDataUltimaCompra().toString());
        }
        jFTFValorCusto.setValue(remedioUpdated.getValorCusto());
        jFTFValorVenda.setValue(remedioUpdated.getValorVenda());
        jTFQntdEstoque.setText(String.valueOf(remedioUpdated.getQuantidade()));
    }

    public Remedio getRemedioUpdated() {
        return remedioUpdated;
    }

    public int getResponse() {
        return response;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JFormattedTextField jFTFValorCusto;
    private javax.swing.JFormattedTextField jFTFValorVenda;
    private javax.swing.JLabel jLInfoDescricao;
    private javax.swing.JLabel jLInfoValorCusto;
    private javax.swing.JLabel jLInfoValorVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFLab;
    private javax.swing.JTextField jTFQntdEstoque;
    private javax.swing.JTextField jTFUltCompra;
    // End of variables declaration//GEN-END:variables
}
