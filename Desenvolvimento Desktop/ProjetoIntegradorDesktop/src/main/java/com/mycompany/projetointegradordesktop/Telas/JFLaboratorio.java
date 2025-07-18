package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import java.awt.Component;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class JFLaboratorio extends javax.swing.JFrame {

    private static Laboratorio labUpdated = null;
    private static Laboratorio newLab = new Laboratorio();
    private static int response;

    public JFLaboratorio() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        loadCampos();
        loadCadastro();
    }

    public JFLaboratorio(Laboratorio lab) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        labUpdated = lab;
        loadCampos();
        loadUpdate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLTitulo = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jTFNumero = new javax.swing.JTextField();
        jTFBairro = new javax.swing.JTextField();
        jTFComplemento = new javax.swing.JTextField();
        jFTFCNPJ = new javax.swing.JFormattedTextField();
        jTFRua = new javax.swing.JTextField();
        jTFCidade = new javax.swing.JTextField();
        jFTFCEP = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jFTFIE = new javax.swing.JFormattedTextField();
        jLErro = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox<>();
        jCBStatus = new javax.swing.JComboBox<>();
        jLStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("Atualização de Laboratório");

        jBSalvar.setBackground(new java.awt.Color(51, 91, 15));
        jBSalvar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBSalvar.setText("Salvar");
        jBSalvar.setBorderPainted(false);
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.setBorderPainted(false);
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nome");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("CNPJ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Inscrição Estadual");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Número");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Rua");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Bairro");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("CEP");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Complemento");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Cidade");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Estado");

        jTFNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFNome.setEnabled(false);

        jTFNumero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTFBairro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTFComplemento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jFTFCNPJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFCNPJ.setEnabled(false);

        jTFRua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTFCidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jFTFCEP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Endereco:");

        jFTFIE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFIE.setEnabled(false);

        jLErro.setForeground(new java.awt.Color(204, 51, 0));

        jCBEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jCBStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jLStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLStatus.setText("Status");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jFTFCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(jTFRua, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jFTFCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jFTFIE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(58, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLStatus)
                        .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFTFCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jFTFIE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLErro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        boolean camposIsValid = validarCampos();
        boolean CNPJIsValid = validarCNPJ();
        boolean IEIsValid = validarIE();
        boolean CEPIsValid = validarCEP();
        if (CNPJIsValid && IEIsValid && CEPIsValid && camposIsValid) {
            if (labUpdated != null) {
                labUpdated.setNumero(jTFNumero.getText());
                labUpdated.setRua(jTFRua.getText());
                labUpdated.setCep(jFTFCEP.getText());
                labUpdated.setBairro(jTFBairro.getText());
                labUpdated.setCidade(jTFCidade.getText());
                labUpdated.setEstado(jCBEstado.getSelectedItem().toString());
                labUpdated.setComplemento(jTFComplemento.getText());
                labUpdated.setStatus(jCBStatus.getSelectedItem().toString().toUpperCase());
                response = 1;
            } else {
                newLab.setNome(jTFNome.getText());
                newLab.setCNPJ(jFTFCNPJ.getText());
                newLab.setInscricaoEstadual(jFTFIE.getText());
                newLab.setNumero(jTFNumero.getText());
                newLab.setRua(jTFRua.getText());
                newLab.setCep(jFTFCEP.getText());
                newLab.setBairro(jTFBairro.getText());
                newLab.setCidade(jTFCidade.getText());
                newLab.setEstado(jCBEstado.getSelectedItem().toString());
                newLab.setComplemento(jTFComplemento.getText());
                response = 2;
            }
            dispose();
        }

    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        response = 0;
        dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    public Laboratorio getLaboratorioUpdated() {
        return labUpdated;
    }

    public Laboratorio getNewLaboratorio() {
        return newLab;
    }

    public int getResponse() {
        return response;
    }

    private void loadCampos() {
        try {
            MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
            mascaraCNPJ.setPlaceholderCharacter('_');
            jFTFCNPJ.setFormatterFactory(new DefaultFormatterFactory(mascaraCNPJ));
            jFTFCNPJ.setColumns(18);

            MaskFormatter mascaraIE = new MaskFormatter("###.###.###.###");
            mascaraIE.setPlaceholderCharacter('_');
            jFTFIE.setFormatterFactory(new DefaultFormatterFactory(mascaraIE));
            jFTFIE.setColumns(15);

            MaskFormatter mascaraCEP = new MaskFormatter("#####-###");
            mascaraCEP.setPlaceholderCharacter('_');
            jFTFCEP.setFormatterFactory(new DefaultFormatterFactory(mascaraCEP));
            jFTFCEP.setColumns(9);

            jFTFCNPJ.setFont(jTFNome.getFont());
            jFTFIE.setFont(jTFNome.getFont());
            jFTFCEP.setFont(jTFNome.getFont());

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar campos: " + e);
        }
    }

    private void loadCadastro() {
        jLTitulo.setText("Cadastro de Laboratório");
        jTFNome.setEnabled(true);
        jFTFCNPJ.setEnabled(true);
        jFTFIE.setEnabled(true);
        jBSalvar.setText("Cadastrar");
        remove(jLStatus);
        remove(jCBStatus);
    }

    private void loadUpdate() {
        jTFNome.setText(labUpdated.getNome());
        jFTFCNPJ.setText(labUpdated.getCNPJ());
        jFTFIE.setText(labUpdated.getInscricaoEstadual());
        jTFNumero.setText(labUpdated.getNumero());
        jTFRua.setText(labUpdated.getRua());
        jFTFCEP.setText(labUpdated.getCep());
        jTFBairro.setText(labUpdated.getBairro());
        jTFCidade.setText(labUpdated.getCidade());
        jCBEstado.setSelectedItem(labUpdated.getEstado());
        jTFComplemento.setText(labUpdated.getComplemento());
        if (!labUpdated.getStatus().equalsIgnoreCase("Ativo")) {
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

    private boolean validarIE() {
        if (!jFTFIE.getText().contains("_")) {
            return true;
        } else {
            jLErro.setText("Inscrição Estadual inválida");
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

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JFLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLaboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLaboratorio().setVisible(true);
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
    private javax.swing.JFormattedTextField jFTFIE;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFCidade;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNumero;
    private javax.swing.JTextField jTFRua;
    // End of variables declaration//GEN-END:variables
}
