package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.Objects.Compra;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import com.mycompany.projetointegradordesktop.Objects.Venda;
import javax.swing.ImageIcon;

public class JFMensagemExcluir extends javax.swing.JFrame {

    private boolean response;
    
    public JFMensagemExcluir() {
        initComponents();
        
    }
    
    public JFMensagemExcluir(Object obj) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        loadMensagem(obj);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLIcon = new javax.swing.JLabel();
        jLMensagem = new javax.swing.JLabel();
        jBCancelar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLMensagem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLMensagem.setText("Tem certeza que deseja excluir esse remédio?");

        jBCancelar.setBackground(new java.awt.Color(204, 204, 204));
        jBCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jBCancelar.setText("Cancelar");
        jBCancelar.setBorderPainted(false);
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBExcluir.setBackground(new java.awt.Color(204, 0, 0));
        jBExcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluir.setText("Excluir");
        jBExcluir.setBorderPainted(false);
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLMensagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addComponent(jLIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLMensagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        response = false;
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        response = true;
        this.dispose();
    }//GEN-LAST:event_jBExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JFMensagemExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMensagemExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMensagemExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMensagemExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMensagemExcluir().setVisible(true);
            }
        });
    }
    
    private void loadMensagem(Object obj) {
        if (obj instanceof Remedio) {
            jLIcon.setIcon(new ImageIcon(getClass().getResource("/Imagens/Remedio Black.png")));
            jLMensagem.setText("Tem certeza que deseja excluir esse remédio?");
        } else if (obj instanceof Compra) {
            jLIcon.setIcon(new ImageIcon(getClass().getResource("/Imagens/Compra Black.png")));
            jLMensagem.setText("Tem certeza que deseja excluir essa compra?");
        } else if (obj instanceof Venda) {
            jLIcon.setIcon(new ImageIcon(getClass().getResource("/Imagens/Venda Black.png")));
            jLMensagem.setText("Tem certeza que deseja excluir essa venda?");
        } else if (obj instanceof Laboratorio) {
            jLIcon.setIcon(new ImageIcon(getClass().getResource("/Imagens/Laboratorio Black.png")));
            jLMensagem.setText("Tem certeza que deseja excluir esse laboratório?");
        } else {
            jLIcon.setIcon(new ImageIcon(getClass().getResource("/Imagens/Drogaria Black.png")));
            jLMensagem.setText("Tem certeza que deseja excluir essa drogaria?");
        }
    }
    
    public boolean getResponse() {
        return response;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JLabel jLIcon;
    private javax.swing.JLabel jLMensagem;
    // End of variables declaration//GEN-END:variables
}
