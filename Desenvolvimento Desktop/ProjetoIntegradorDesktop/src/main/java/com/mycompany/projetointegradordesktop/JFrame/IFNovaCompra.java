package com.mycompany.projetointegradordesktop.JFrame;

import com.mycompany.projetointegradordesktop.DAO.CompraDAO;
import com.mycompany.projetointegradordesktop.DAO.ItemDAO;
import com.mycompany.projetointegradordesktop.DAO.LaboratorioDAO;
import com.mycompany.projetointegradordesktop.DAO.RemedioDAO;
import com.mycompany.projetointegradordesktop.Model.ItemTableModel;
import com.mycompany.projetointegradordesktop.Objects.Compra;
import com.mycompany.projetointegradordesktop.Objects.Item;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

public class IFNovaCompra extends javax.swing.JInternalFrame {

    private double total = 0;

    ItemTableModel model = new ItemTableModel();
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public IFNovaCompra() {
        initComponents();
        loadCampoData();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        jTItens.setModel(model);
        loadLaboratorios();
        loadRemedios();
        jLTotal.setText("Total: R$ " + total);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBLaboratorio = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTItens = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jCBRemedio = new javax.swing.JComboBox<>();
        jTFQuantidade = new javax.swing.JTextField();
        jTFValorUnt = new javax.swing.JTextField();
        jBAdicionar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLTotal = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jBRemover = new javax.swing.JButton();
        jFTFData = new javax.swing.JFormattedTextField();
        jCBPagamento = new javax.swing.JComboBox<>();
        jLInfoCompra = new javax.swing.JLabel();
        jLInfoData = new javax.swing.JLabel();

        setBorder(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("Nova Compra");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Data:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Fornecedor:");

        jCBLaboratorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBLaboratorioActionPerformed(evt);
            }
        });

        jTItens.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTItens);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Itens da Compra");

        jCBRemedio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRemedioActionPerformed(evt);
            }
        });

        jTFQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTFValorUnt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFValorUnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFValorUnt.setFocusable(false);

        jBAdicionar.setBackground(new java.awt.Color(51, 90, 15));
        jBAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jBAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        jBAdicionar.setText("+");
        jBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Resumo");

        jLTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTotal.setText("Total: ");

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Remédio");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Quantidade");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Valor Unit.");

        jBRemover.setBackground(new java.awt.Color(204, 51, 0));
        jBRemover.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBRemover.setForeground(new java.awt.Color(255, 255, 255));
        jBRemover.setText("Remover");
        jBRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverActionPerformed(evt);
            }
        });

        jFTFData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jFTFData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFDataFocusLost(evt);
            }
        });

        jCBPagamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Débito", "Crédito", "Cheque", "Boleto", "" }));

        jLInfoCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLInfoCompra.setForeground(new java.awt.Color(204, 0, 0));
        jLInfoCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLInfoData.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(307, 307, 307)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel6)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLInfoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLTotal))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTFValorUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(13, 13, 13)
                                            .addComponent(jBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLInfoData, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)))
                    .addComponent(jLInfoData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(jCBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFValorUnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTotal)
                    .addComponent(jCBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLInfoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jCBLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBLaboratorioActionPerformed
        model.removeAllItens();
        loadRemedios();
    }//GEN-LAST:event_jCBLaboratorioActionPerformed

    private void jCBRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRemedioActionPerformed
        Remedio remedio = (Remedio) jCBRemedio.getSelectedItem();
        if (remedio != null) {
            jTFValorUnt.setText("R$ " + String.valueOf(remedio.getValorCusto()).replace(".", ","));
        }
    }//GEN-LAST:event_jCBRemedioActionPerformed

    private void jBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarActionPerformed
        Item item = new Item();
        if (jCBRemedio.getSelectedItem() != null && !jTFQuantidade.getText().equals("")) {
            if (Integer.parseInt(jTFQuantidade.getText()) > 0) {
                item.setRemedio((Remedio) jCBRemedio.getSelectedItem());
                item.setQuantidade(Integer.parseInt(jTFQuantidade.getText()));
                item.setSubtotal(item.getQuantidade() * item.getRemedio().getValorCusto());
                total += item.getSubtotal();
                loadTotal();
                model.addLinha(item);
                jLInfoCompra.setText("");
            }
        }
    }//GEN-LAST:event_jBAdicionarActionPerformed

    private void jBRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoverActionPerformed
        if (jTItens.getSelectedRow() != -1) {
            total -= model.getItens().get(jTItens.getSelectedRow()).getSubtotal();
            loadTotal();
            model.deleteLinha(jTItens.getSelectedRow());
        }
    }//GEN-LAST:event_jBRemoverActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (total > 0) {
            Compra compra = new Compra();

            compra.setDataCompra(LocalDate.parse(jFTFData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            compra.setLaboratorio((Laboratorio) jCBLaboratorio.getSelectedItem());
            compra.setTotalNota(total);
            compra.setNmr_nota_fiscal(String.valueOf(new Random().nextInt(99999)));
            compra.setPagamento(jCBPagamento.getSelectedItem().toString());

            int idNovaCompra = CompraDAO.create(compra);
            System.out.println(idNovaCompra);
            for (Item item: model.getItens()) {
                item.setIdTransacao(idNovaCompra);
            }
            
            ItemDAO.create(model.getItens(), "compra");
            
            
            
            this.dispose();
        } else {
            jLInfoCompra.setText("Adicione pelo menos 1 remédio a compra");
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jFTFDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDataFocusLost
        if (jFTFData.getText().contains("_")) {
            jLInfoData.setText("Preencha todos os digitos");
        } else {
            try {
                LocalDate.parse(jFTFData.getText(), dtf);
                jLInfoData.setText("");
            } catch (DateTimeParseException e) {
                jLInfoData.setText("Data inváida!");
                loadCampoData();
                jFTFData.requestFocus();
            }
        }
    }//GEN-LAST:event_jFTFDataFocusLost

    public void loadLaboratorios() {
        jCBLaboratorio.removeAllItems();
        for (Laboratorio l : LaboratorioDAO.read()) {
            jCBLaboratorio.addItem(l);
        }
    }

    public void loadRemedios() {
        jCBRemedio.removeAllItems();
        for (Remedio remedio : RemedioDAO.read((Laboratorio) jCBLaboratorio.getSelectedItem())) {
            jCBRemedio.addItem(remedio);
        }
    }

    public void loadTotal() {
        jLTotal.setText("Total: R$ " + total);
    }

    public void loadCampoData() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            mascara.install(jFTFData);
            jFTFData.setColumns(10);
            jFTFData.setFont(jCBLaboratorio.getFont());
            jFTFData.setText(LocalDate.now().format(dtf));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar campo data: " + e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdicionar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBRemover;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Laboratorio> jCBLaboratorio;
    private javax.swing.JComboBox<String> jCBPagamento;
    private javax.swing.JComboBox<Remedio> jCBRemedio;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JLabel jLInfoCompra;
    private javax.swing.JLabel jLInfoData;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFQuantidade;
    private javax.swing.JTextField jTFValorUnt;
    private javax.swing.JTable jTItens;
    // End of variables declaration//GEN-END:variables
}
