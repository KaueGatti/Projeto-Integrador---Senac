package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.DAO.LaboratorioDAO;
import com.mycompany.projetointegradordesktop.DAO.RemedioDAO;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import com.mycompany.projetointegradordesktop.Util.FormatadorValor;
import java.util.function.Consumer;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class JFRemedio extends javax.swing.JFrame {

    private Remedio newRemedio = new Remedio();
    private static boolean response;

    public JFRemedio() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        loadLaboratorios();
        loadCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jFTFValorCusto = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jFTFValorVenda = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLInfoValorCusto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLInfoValorVenda = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBCadastrar = new javax.swing.JButton();
        jLInfoDescricao = new javax.swing.JLabel();
        jBCancelar = new javax.swing.JButton();
        jTFDescricao = new javax.swing.JTextField();
        jCBLaboratorio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Laboratório");

        jFTFValorCusto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFValorCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFValorCustoFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Descrição");

        jFTFValorVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFValorVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFValorVendaFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Valor de Custo");

        jLInfoValorCusto.setForeground(new java.awt.Color(204, 51, 0));
        jLInfoValorCusto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Valor de Venda");

        jLInfoValorVenda.setForeground(new java.awt.Color(204, 51, 0));
        jLInfoValorVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cadastro de Remédio");

        jBCadastrar.setBackground(new java.awt.Color(51, 91, 15));
        jBCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrar.setText("Cadastrar");
        jBCadastrar.setBorderPainted(false);
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jLInfoDescricao.setForeground(new java.awt.Color(204, 51, 0));
        jLInfoDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jBCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jBCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jBCancelar.setText("Cancelar");
        jBCancelar.setBorderPainted(false);
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jTFDescricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFDescricao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFDescricaoFocusLost(evt);
            }
        });

        jCBLaboratorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLInfoValorCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFDescricao)
                            .addComponent(jFTFValorCusto)
                            .addComponent(jFTFValorVenda)
                            .addComponent(jLInfoValorVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(jLInfoDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBLaboratorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jCBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLInfoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFTFValorCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorCustoFocusLost
        validarCampoNumerico(jFTFValorCusto, jLInfoValorCusto, newRemedio::setValorCusto);
    }//GEN-LAST:event_jFTFValorCustoFocusLost

    private void jFTFValorVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorVendaFocusLost
        validarCampoNumerico(jFTFValorVenda, jLInfoValorVenda, newRemedio::setValorVenda);
    }//GEN-LAST:event_jFTFValorVendaFocusLost

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        newRemedio.setLaboratorio((Laboratorio) jCBLaboratorio.getSelectedItem());
        boolean descricaoIsValid = validarDescricao();
        boolean valorCustoIsValid = validarCampoNumerico(jFTFValorCusto, jLInfoValorCusto, newRemedio::setValorCusto);
        boolean valorVendaIsValid = validarCampoNumerico(jFTFValorVenda, jLInfoValorVenda, newRemedio::setValorVenda);
        if (descricaoIsValid && valorCustoIsValid && valorVendaIsValid) {
            RemedioDAO.create(newRemedio);
            response = true;
            dispose();
        }
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        response = false;
        dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTFDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFDescricaoFocusLost
        validarDescricao();
    }//GEN-LAST:event_jTFDescricaoFocusLost

    private void loadLaboratorios() {
        jCBLaboratorio.removeAllItems();
        for (Laboratorio l : LaboratorioDAO.read()) {
            jCBLaboratorio.addItem(l);
        }
    }

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
            newRemedio.setDescricao(descricao);
            jLInfoDescricao.setText("");
            return true;
        } else {
            jLInfoDescricao.setText("Defina uma descrição");
            return false;
        }
    }

    public void loadCampos() {
        FormatadorValor.formatarCampo(jFTFValorCusto);
        FormatadorValor.formatarCampo(jFTFValorVenda);
        jFTFValorCusto.setFont(jTFDescricao.getFont());
        jFTFValorVenda.setFont(jTFDescricao.getFont());
        jFTFValorCusto.setValue(0D);
        jFTFValorVenda.setValue(0D);
    }

    public static boolean getResponse() {
        return response;
    }

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
            java.util.logging.Logger.getLogger(JFRemedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRemedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRemedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRemedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFRemedio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JComboBox<Laboratorio> jCBLaboratorio;
    private javax.swing.JFormattedTextField jFTFValorCusto;
    private javax.swing.JFormattedTextField jFTFValorVenda;
    private javax.swing.JLabel jLInfoDescricao;
    private javax.swing.JLabel jLInfoValorCusto;
    private javax.swing.JLabel jLInfoValorVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTFDescricao;
    // End of variables declaration//GEN-END:variables
}
