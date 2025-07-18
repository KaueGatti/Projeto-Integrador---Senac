package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.DAO.DrogariaDAO;
import com.mycompany.projetointegradordesktop.Model.DrogariaTableModel;
import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class IFDrogaria extends javax.swing.JInternalFrame {

    DrogariaTableModel model = new DrogariaTableModel();

    public IFDrogaria() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
        loadOrdenar();
        jLDrogaria.setIcon(new ImageIcon(getClass().getResource("/Imagens/Drogaria Black.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLDrogaria = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDrogaria = new javax.swing.JTable();
        jBCadastrarDrogaria = new javax.swing.JButton();
        jBAtualizarDrogaria = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jBPesquisar = new javax.swing.JButton();
        jBFiltrar = new javax.swing.JButton();
        jCBOrdenar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCBoxDesc = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jCBTipoPesquisa = new javax.swing.JComboBox<>();
        jCBEstado = new javax.swing.JComboBox<>();
        jFTFPesquisa = new javax.swing.JFormattedTextField();
        jCBStatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setMaximizable(true);

        jLDrogaria.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLDrogaria.setText("Drogarias");

        jTDrogaria.setModel(new javax.swing.table.DefaultTableModel(
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
        jTDrogaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDrogariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTDrogaria);

        jBCadastrarDrogaria.setBackground(new java.awt.Color(51, 90, 15));
        jBCadastrarDrogaria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastrarDrogaria.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrarDrogaria.setText("Cadastrar Drogaria");
        jBCadastrarDrogaria.setBorder(null);
        jBCadastrarDrogaria.setBorderPainted(false);
        jBCadastrarDrogaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarDrogariaActionPerformed(evt);
            }
        });

        jBAtualizarDrogaria.setBackground(new java.awt.Color(204, 204, 204));
        jBAtualizarDrogaria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBAtualizarDrogaria.setForeground(new java.awt.Color(0, 0, 0));
        jBAtualizarDrogaria.setText("Atualizar Drogaria");
        jBAtualizarDrogaria.setBorder(null);
        jBAtualizarDrogaria.setBorderPainted(false);
        jBAtualizarDrogaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarDrogariaActionPerformed(evt);
            }
        });

        jBPesquisar.setBackground(new java.awt.Color(153, 153, 153));
        jBPesquisar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        jBPesquisar.setText("Pesquisar");
        jBPesquisar.setBorder(null);
        jBPesquisar.setBorderPainted(false);
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
        jBFiltrar.setBorderPainted(false);
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
        jCBTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CNPJ" }));
        jCBTipoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoPesquisaActionPerformed(evt);
            }
        });

        jCBEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jFTFPesquisa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jCBStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Ativo", "Inativo" }));
        jCBStatus.setSelectedIndex(1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Status");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCBTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBoxDesc))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(375, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jCBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBoxDesc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jLDrogaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                        .addComponent(jBCadastrarDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBAtualizarDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBCadastrarDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAtualizarDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLDrogaria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTDrogariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDrogariaMouseClicked
        if (jTDrogaria.getSelectedRow() != -1) {
            Drogaria drogaria = model.getDrogarias().get(jTDrogaria.getSelectedRow());
            if (evt.getClickCount() == 2) {
                openDrogariaWindow(drogaria);
            }
        }
    }//GEN-LAST:event_jTDrogariaMouseClicked

    private void jBCadastrarDrogariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarDrogariaActionPerformed
        openDrogariaWindow(null);
    }//GEN-LAST:event_jBCadastrarDrogariaActionPerformed

    private void jBAtualizarDrogariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarDrogariaActionPerformed
        if (jTDrogaria.getSelectedRow() != -1) {
            Drogaria drogaria = model.getDrogarias().get(jTDrogaria.getSelectedRow());
            openDrogariaWindow(drogaria);
        }
    }//GEN-LAST:event_jBAtualizarDrogariaActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        model.setDrogarias(DrogariaDAO.readDinamico(jFTFPesquisa.getText(), jCBTipoPesquisa.getSelectedIndex(), null, "Ativo", null, false));
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFiltrarActionPerformed
        String pesquisa = jFTFPesquisa.getText();
        int tipoPesquisa = jCBTipoPesquisa.getSelectedIndex();
        String estado = null;
        String status = null;
        String orderBy = null;
        boolean desc = false;

        if (jCBEstado.getSelectedIndex() != 0) {
            estado = jCBEstado.getSelectedItem().toString();
        }
        if (jCBStatus.getSelectedIndex() != 0) {
            status = jCBStatus.getSelectedItem().toString();
        }
        if (jCBOrdenar.getSelectedIndex() != 0) {
            orderBy = getOrdenar();
        }
        if (jCBoxDesc.isSelected()) {
            desc = true;
        }
        model.setDrogarias(DrogariaDAO.readDinamico(pesquisa, tipoPesquisa, estado, status, orderBy, desc));
    }//GEN-LAST:event_jBFiltrarActionPerformed

    private void jCBTipoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoPesquisaActionPerformed
        try {
            if (jCBTipoPesquisa.getSelectedIndex() == 1) {
                MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
                mascaraCNPJ.setPlaceholderCharacter('_');
                jFTFPesquisa.setFormatterFactory(new DefaultFormatterFactory(mascaraCNPJ));
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
        jTDrogaria.setModel(model);
        model.loadTable();
        jTDrogaria.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jTDrogaria.setRowHeight(24);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(SwingConstants.CENTER);
        jTDrogaria.getColumnModel().getColumn(1).setCellRenderer(centralizador);
        jTDrogaria.getColumnModel().getColumn(2).setCellRenderer(centralizador);
        jTDrogaria.getColumnModel().getColumn(4).setCellRenderer(centralizador);
        jTDrogaria.getColumnModel().getColumn(7).setCellRenderer(centralizador);
        jTDrogaria.getColumnModel().getColumn(9).setCellRenderer(centralizador);
    }

    private void openDrogariaWindow(Drogaria drogaria) {
        JFDrogaria JFDrogaria;
        if (drogaria != null) {
            JFDrogaria = new JFDrogaria(drogaria);
        } else {
            JFDrogaria = new JFDrogaria();
        }
        JFDrogaria.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (JFDrogaria.getResponse() == 1) {
                    Drogaria drogariaUpdated = JFDrogaria.getDrogariaUpdated();
                    model.setValueAt(drogariaUpdated.getNumero(), jTDrogaria.getSelectedRow(), 2);
                    model.setValueAt(drogariaUpdated.getRua(), jTDrogaria.getSelectedRow(), 3);
                    model.setValueAt(drogariaUpdated.getCep(), jTDrogaria.getSelectedRow(), 4);
                    model.setValueAt(drogariaUpdated.getBairro(), jTDrogaria.getSelectedRow(), 5);
                    model.setValueAt(drogariaUpdated.getCidade(), jTDrogaria.getSelectedRow(), 6);
                    model.setValueAt(drogariaUpdated.getEstado(), jTDrogaria.getSelectedRow(), 7);
                    model.setValueAt(drogariaUpdated.getComplemento(), jTDrogaria.getSelectedRow(), 8);
                    DrogariaDAO.update(drogariaUpdated);
                } else if (JFDrogaria.getResponse() == 2) {
                    DrogariaDAO.create(JFDrogaria.getNewDrogaria());
                }
                model.loadTable();
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
                return "numero";
            case 4:
                return "rua";
            case 5:
                return "cep";
            case 6:
                return "bairro";
            case 7:
                return "cidade";
            case 8:
                return "uf";
            case 9:
                return "complemento";
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizarDrogaria;
    private javax.swing.JButton jBCadastrarDrogaria;
    private javax.swing.JButton jBFiltrar;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<String> jCBEstado;
    private javax.swing.JComboBox<String> jCBOrdenar;
    private javax.swing.JComboBox<String> jCBStatus;
    private javax.swing.JComboBox<String> jCBTipoPesquisa;
    private javax.swing.JCheckBox jCBoxDesc;
    private javax.swing.JFormattedTextField jFTFPesquisa;
    private javax.swing.JLabel jLDrogaria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDrogaria;
    // End of variables declaration//GEN-END:variables
}
