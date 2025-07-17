package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import java.awt.Component;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class JFDrogaria extends javax.swing.JFrame {

    private static Drogaria drogariaUpdated = null;
    private static Drogaria newDrogaria = new Drogaria();
    private static int response;

    public JFDrogaria() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        loadCampos();
        loadCadastro();
    }

    public JFDrogaria(Drogaria drogaria) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        loadCampos();
        drogariaUpdated = drogaria;
        loadUpdate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jTFComplemento = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jFTFCNPJ = new javax.swing.JFormattedTextField();
        jTFRua = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTFCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jFTFCEP = new javax.swing.JFormattedTextField();
        jTFNome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTFNumero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTFBairro = new javax.swing.JTextField();
        jLTitulo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jBCancelar = new javax.swing.JButton();
        jLErro = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox<>();
        jLStatus = new javax.swing.JLabel();
        jCBStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Cidade");

        jTFComplemento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Estado");

        jFTFCNPJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFCNPJ.setEnabled(false);

        jTFRua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nome");

        jTFCidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("CNPJ");

        jFTFCEP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTFNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFNome.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Número");

        jTFNumero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Endereco:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Rua");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Bairro");

        jTFBairro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("Atualização de Drogaria");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("CEP");

        jBSalvar.setBackground(new java.awt.Color(51, 91, 15));
        jBSalvar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Complemento");

        jBCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLErro.setForeground(new java.awt.Color(204, 51, 0));

        jCBEstado.setEditable(true);
        jCBEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLStatus.setText("Status");

        jCBStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativado", "Desativado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLErro, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLStatus)
                                .addGap(18, 18, 18)
                                .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)))
                                .addGap(18, 18, 18)
                                .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jTFRua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jFTFCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jFTFCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(58, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLStatus)
                    .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFTFCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLErro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        boolean camposIsValid = validarCampos();
        boolean CNPJIsValid = validarCNPJ();
        boolean CEPIsValid = validarCEP();
        if (CNPJIsValid && CEPIsValid && camposIsValid) {
            if (drogariaUpdated != null) {
                drogariaUpdated.setNumero(jTFNumero.getText());
                drogariaUpdated.setRua(jTFRua.getText());
                drogariaUpdated.setCep(jFTFCEP.getText());
                drogariaUpdated.setBairro(jTFBairro.getText());
                drogariaUpdated.setCidade(jTFCidade.getText());
                drogariaUpdated.setEstado(jCBEstado.getSelectedItem().toString());
                drogariaUpdated.setComplemento(jTFComplemento.getText());
                drogariaUpdated.setStatus(jCBStatus.getSelectedItem().toString().toUpperCase());
                response = 1;
            } else {
                newDrogaria.setNome(jTFNumero.getText());
                newDrogaria.setCNPJ(jFTFCNPJ.getText());
                newDrogaria.setNumero(jTFNumero.getText());
                newDrogaria.setRua(jTFRua.getText());
                newDrogaria.setCep(jFTFCEP.getText());
                newDrogaria.setBairro(jTFBairro.getText());
                newDrogaria.setCidade(jTFCidade.getText());
                newDrogaria.setEstado(jCBEstado.getSelectedItem().toString());
                newDrogaria.setComplemento(jTFComplemento.getText());
                response = 2;
            }
            dispose();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        response = 0;
        dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void loadCampos() {
        try {
            MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
            mascaraCNPJ.setPlaceholderCharacter('_');
            jFTFCNPJ.setFormatterFactory(new DefaultFormatterFactory(mascaraCNPJ));
            jFTFCNPJ.setColumns(18);

            MaskFormatter mascaraCEP = new MaskFormatter("#####-###");
            mascaraCEP.setPlaceholderCharacter('_');
            jFTFCEP.setFormatterFactory(new DefaultFormatterFactory(mascaraCEP));
            jFTFCEP.setColumns(9);

            jFTFCNPJ.setFont(jTFNumero.getFont());
            jFTFCEP.setFont(jTFNumero.getFont());

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar campos: " + e);
        }
    }

    private void loadCadastro() {
        jLTitulo.setText("Cadastro de Laboratório");
        jTFNome.setEnabled(true);
        jFTFCNPJ.setEnabled(true);
        jBSalvar.setText("Cadastrar");
        remove(jLStatus);
        remove(jCBStatus);
    }

    private void loadUpdate() {
        jTFNome.setText(drogariaUpdated.getNome());
        jFTFCNPJ.setText(drogariaUpdated.getCNPJ());
        jTFNumero.setText(drogariaUpdated.getNumero());
        jTFRua.setText(drogariaUpdated.getRua());
        jFTFCEP.setText(drogariaUpdated.getCep());
        jTFBairro.setText(drogariaUpdated.getBairro());
        jTFCidade.setText(drogariaUpdated.getCidade());
        jCBEstado.setSelectedItem(drogariaUpdated.getEstado());
        jTFComplemento.setText(drogariaUpdated.getComplemento());
        if (!drogariaUpdated.getStatus().equalsIgnoreCase("Ativado")) {
            jCBStatus.setSelectedIndex(1);
        }
    }

    private boolean validarCNPJ() {
        if (!jFTFCNPJ.getText().contains("_")) {
            return true;
        } else {
            jLErro.setText("CNPJ inválido");
            return false;
        }
    }

    private boolean validarCEP() {
        if (!jFTFCEP.getText().contains("_")) {
            return true;
        } else {
            jLErro.setText("CEP inválido");
            return false;
        }
    }

    private boolean validarCampos() {
        for (Component comp : getComponents()) {
            if (comp instanceof JTextField campo) {
                if (campo.getText().equals("")) {
                    jLErro.setText("Preencha todos os campos");
                    return false;
                }
            }
        }
        return true;
    }

    public Drogaria getDrogariaUpdated() {
        return drogariaUpdated;
    }

    public Drogaria getNewDrogaria() {
        return newDrogaria;
    }

    public int getResponse() {
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
            java.util.logging.Logger.getLogger(JFDrogaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFDrogaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFDrogaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFDrogaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFDrogaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBEstado;
    private javax.swing.JComboBox<String> jCBStatus;
    private javax.swing.JFormattedTextField jFTFCEP;
    private javax.swing.JFormattedTextField jFTFCNPJ;
    private javax.swing.JLabel jLErro;
    private javax.swing.JLabel jLStatus;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFCidade;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNumero;
    private javax.swing.JTextField jTFRua;
    // End of variables declaration//GEN-END:variables
}
