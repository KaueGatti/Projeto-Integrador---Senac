package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.DAO.LaboratorioDAO;
import com.mycompany.projetointegradordesktop.Model.LaboratorioTableModel;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class IFLaboratorio extends javax.swing.JInternalFrame {

    LaboratorioTableModel model = new LaboratorioTableModel();

    public IFLaboratorio() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
        loadOrdenar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBAtualizarLaboratorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLaboratorio = new javax.swing.JTable();
        jBCadastrarLaboratorio = new javax.swing.JButton();
        jBExcluirLaboratorio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBPesquisar = new javax.swing.JButton();
        jBFiltrar = new javax.swing.JButton();
        jCBOrdenar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCBoxDesc = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jCBTipoPesquisa = new javax.swing.JComboBox<>();
        jCBEstado = new javax.swing.JComboBox<>();
        jFTFPesquisa = new javax.swing.JFormattedTextField();

        setBorder(null);
        setClosable(true);
        setMaximizable(true);

        jBAtualizarLaboratorio.setBackground(new java.awt.Color(204, 204, 204));
        jBAtualizarLaboratorio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBAtualizarLaboratorio.setForeground(new java.awt.Color(0, 0, 0));
        jBAtualizarLaboratorio.setText("Atualizar Laboratório");
        jBAtualizarLaboratorio.setBorder(null);
        jBAtualizarLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarLaboratorioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Laboratórios");

        jTLaboratorio.setModel(new javax.swing.table.DefaultTableModel(
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
        jTLaboratorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTLaboratorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTLaboratorio);

        jBCadastrarLaboratorio.setBackground(new java.awt.Color(51, 90, 15));
        jBCadastrarLaboratorio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastrarLaboratorio.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrarLaboratorio.setText("Cadastrar Laboratório");
        jBCadastrarLaboratorio.setBorder(null);
        jBCadastrarLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarLaboratorioActionPerformed(evt);
            }
        });

        jBExcluirLaboratorio.setBackground(new java.awt.Color(153, 51, 0));
        jBExcluirLaboratorio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBExcluirLaboratorio.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluirLaboratorio.setText("Excluir Laboratório");
        jBExcluirLaboratorio.setBorder(null);
        jBExcluirLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirLaboratorioActionPerformed(evt);
            }
        });

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

        jCBOrdenar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Ordenar por");

        jCBoxDesc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBoxDesc.setText("Decrescente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Estado");

        jCBTipoPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CNPJ", "IE" }));
        jCBTipoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoPesquisaActionPerformed(evt);
            }
        });

        jCBEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jFTFPesquisa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCBTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBoxDesc)))
                .addContainerGap(413, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jCBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBoxDesc))
                .addGap(18, 18, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addComponent(jBCadastrarLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBAtualizarLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluirLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBCadastrarLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBExcluirLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAtualizarLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAtualizarLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarLaboratorioActionPerformed
        if (jTLaboratorio.getSelectedRow() != -1) {
            Laboratorio lab = model.getLaboratorios().get(jTLaboratorio.getSelectedRow());
            openLaboratorioWindow(lab);
        }
    }//GEN-LAST:event_jBAtualizarLaboratorioActionPerformed

    private void jTLaboratorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLaboratorioMouseClicked
        if (jTLaboratorio.getSelectedRow() != -1) {
            Laboratorio lab = model.getLaboratorios().get(jTLaboratorio.getSelectedRow());
            if (evt.getClickCount() == 2) {
                openLaboratorioWindow(lab);
            }
        }
    }//GEN-LAST:event_jTLaboratorioMouseClicked

    private void jBCadastrarLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarLaboratorioActionPerformed
        openLaboratorioWindow(null);
    }//GEN-LAST:event_jBCadastrarLaboratorioActionPerformed

    private void jBExcluirLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirLaboratorioActionPerformed
        if (jTLaboratorio.getSelectedRow() != -1) {
            LaboratorioDAO.delete(model.getLaboratorios().get(jTLaboratorio.getSelectedRow()));
            model.deleteLinha(jTLaboratorio.getSelectedRow());
        }
    }//GEN-LAST:event_jBExcluirLaboratorioActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        model.setLaboratorios(LaboratorioDAO.readDinamico(jFTFPesquisa.getText(), jCBTipoPesquisa.getSelectedIndex(), null, null, false));
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFiltrarActionPerformed
        String pesquisa = jFTFPesquisa.getText();
        int tipoPesquisa = jCBTipoPesquisa.getSelectedIndex();
        String estado = null;
        String orderBy = null;
        boolean desc = false;

        if (jCBEstado.getSelectedIndex() != 0) {
            estado = jCBEstado.getSelectedItem().toString();
        }
        if (jCBOrdenar.getSelectedIndex() != 0) {
            orderBy = getOrdenar();
        }
        if (jCBoxDesc.isSelected()) {
            desc = true;
        }
        model.setLaboratorios(LaboratorioDAO.readDinamico(pesquisa, tipoPesquisa, estado, orderBy, desc));
    }//GEN-LAST:event_jBFiltrarActionPerformed

    private void jCBTipoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoPesquisaActionPerformed
        try {
            if (jCBTipoPesquisa.getSelectedIndex() == 1) {
                MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
                mascaraCNPJ.setPlaceholderCharacter('_');
                jFTFPesquisa.setFormatterFactory(new DefaultFormatterFactory(mascaraCNPJ));
                jFTFPesquisa.setColumns(30);
                jFTFPesquisa.setFocusLostBehavior(JFormattedTextField.PERSIST);
            } else if (jCBTipoPesquisa.getSelectedIndex() == 2) {
                MaskFormatter mascaraIE = new MaskFormatter("###.###.###.###");
                mascaraIE.setPlaceholderCharacter('_');
                jFTFPesquisa.setFormatterFactory(new DefaultFormatterFactory(mascaraIE));
                jFTFPesquisa.setColumns(30);
                jFTFPesquisa.setFocusLostBehavior(JFormattedTextField.PERSIST);
            } else {
                jFTFPesquisa.setFormatterFactory(new DefaultFormatterFactory());
                jFTFPesquisa.setText("");
                jFTFPesquisa.setColumns(30);
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar campo de pesquisa: " + e);
        }
    }//GEN-LAST:event_jCBTipoPesquisaActionPerformed

    private void loadTable() {
        jTLaboratorio.setModel(model);
        model.loadTable();
        jTLaboratorio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jTLaboratorio.setRowHeight(24);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(SwingConstants.CENTER);
        jTLaboratorio.getColumnModel().getColumn(1).setCellRenderer(centralizador);
        jTLaboratorio.getColumnModel().getColumn(2).setCellRenderer(centralizador);
        jTLaboratorio.getColumnModel().getColumn(5).setCellRenderer(centralizador);
        jTLaboratorio.getColumnModel().getColumn(8).setCellRenderer(centralizador);
    }

    private void openLaboratorioWindow(Laboratorio lab) {
        JFLaboratorio JFLaboratorio;
        if (lab != null) {
            JFLaboratorio = new JFLaboratorio(lab);
        } else {
            JFLaboratorio = new JFLaboratorio();
        }
        JFLaboratorio.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (JFLaboratorio.getResponse() == 1) {
                    Laboratorio labUpdated = JFLaboratorio.getLaboratorioUpdated();
                    model.setValueAt(labUpdated.getNumero(), jTLaboratorio.getSelectedRow(), 3);
                    model.setValueAt(labUpdated.getRua(), jTLaboratorio.getSelectedRow(), 4);
                    model.setValueAt(labUpdated.getCep(), jTLaboratorio.getSelectedRow(), 5);
                    model.setValueAt(labUpdated.getBairro(), jTLaboratorio.getSelectedRow(), 6);
                    model.setValueAt(labUpdated.getCidade(), jTLaboratorio.getSelectedRow(), 7);
                    model.setValueAt(labUpdated.getEstado(), jTLaboratorio.getSelectedRow(), 8);
                    model.setValueAt(labUpdated.getComplemento(), jTLaboratorio.getSelectedRow(), 9);
                    LaboratorioDAO.update(labUpdated);
                } else if (JFLaboratorio.getResponse() == 2) {
                    LaboratorioDAO.create(JFLaboratorio.getNewLaboratorio());
                    model.loadTable();
                }
            }
        });
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
                return "nome";
            case 2:
                return "cnpj";
            case 3:
                return "ie";
            case 4:
                return "numero";
            case 5:
                return "rua";
            case 6:
                return "cep";
            case 7:
                return "bairro";
            case 8:
                return "cidade";
            case 9:
                return "uf";
            case 10:
                return "complemento";
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizarLaboratorio;
    private javax.swing.JButton jBCadastrarLaboratorio;
    private javax.swing.JButton jBExcluirLaboratorio;
    private javax.swing.JButton jBFiltrar;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<String> jCBEstado;
    private javax.swing.JComboBox<String> jCBOrdenar;
    private javax.swing.JComboBox<String> jCBTipoPesquisa;
    private javax.swing.JCheckBox jCBoxDesc;
    private javax.swing.JFormattedTextField jFTFPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTLaboratorio;
    // End of variables declaration//GEN-END:variables
}
