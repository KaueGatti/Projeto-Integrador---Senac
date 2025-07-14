package com.mycompany.projetointegradordesktop.JFrame;

import com.mycompany.projetointegradordesktop.DAO.DrogariaDAO;
import com.mycompany.projetointegradordesktop.DAO.ItemDAO;
import com.mycompany.projetointegradordesktop.DAO.RemedioDAO;
import com.mycompany.projetointegradordesktop.DAO.VendaDAO;
import com.mycompany.projetointegradordesktop.Model.ItemTableModel;
import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import com.mycompany.projetointegradordesktop.Objects.Item;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import com.mycompany.projetointegradordesktop.Objects.Venda;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

public class IFNovaVenda extends javax.swing.JInternalFrame {

    ItemTableModel model = new ItemTableModel();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private double total = 0;

    public IFNovaVenda() {
        initComponents();
        loadCampoData();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        jTItens.setModel(model);
        loadDrogarias();
        loadRemedios();
        jLTotal.setText("Total: R$ " + total);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFValorUnt = new javax.swing.JTextField();
        jBAdicionar = new javax.swing.JButton();
        jCBPagamento = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLInfoCompra = new javax.swing.JLabel();
        jLTotal = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jCBDrogaria = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTItens = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jCBRemedio = new javax.swing.JComboBox<>();
        jBRemover = new javax.swing.JButton();
        jTFQuantidade = new javax.swing.JTextField();
        jFTFData = new javax.swing.JFormattedTextField();
        jLInfoData = new javax.swing.JLabel();

        setBorder(null);

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

        jCBPagamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Débito", "Crédito", "Cheque", "Boleto", "" }));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setText("Resumo");

        jLInfoCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLInfoCompra.setForeground(new java.awt.Color(204, 0, 0));
        jLInfoCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Remédio");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Quantidade");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Valor Unit.");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel21.setText("Nova Venda");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("Data:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Cliente:");

        jCBDrogaria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
        jScrollPane3.setViewportView(jTItens);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Itens da Venda");

        jCBRemedio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRemedioActionPerformed(evt);
            }
        });

        jBRemover.setBackground(new java.awt.Color(204, 51, 0));
        jBRemover.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBRemover.setForeground(new java.awt.Color(255, 255, 255));
        jBRemover.setText("Remover");
        jBRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverActionPerformed(evt);
            }
        });

        jTFQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTFQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jFTFData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jFTFData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTFData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFDataFocusLost(evt);
            }
        });

        jLInfoData.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(307, 307, 307)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLInfoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3)
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
                                        .addComponent(jBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLInfoData, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(jCBDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel23))
                            .addComponent(jCBDrogaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
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
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLTotal)
                            .addComponent(jCBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLInfoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLInfoData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarActionPerformed
        Item item = new Item();
        Remedio remedio = (Remedio) jCBRemedio.getSelectedItem();
        if (!jTFQuantidade.getText().equals("")) {
            if (Integer.parseInt(jTFQuantidade.getText()) > 0) {
                if (!(Integer.parseInt(jTFQuantidade.getText()) > remedio.getQuantidade())) {
                    item.setRemedio((Remedio) jCBRemedio.getSelectedItem());
                    item.setQuantidade(Integer.parseInt(jTFQuantidade.getText()));
                    item.setSubtotal(item.getQuantidade() * item.getRemedio().getValorCusto());
                    total += item.getSubtotal();
                    loadTotal();
                    model.addLinha(item);
                    jLInfoCompra.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "A quantidade em estoque é menor do que a solicitada"
                            + "\nQuantidade solicitada: " + jTFQuantidade.getText() 
                            + "\nQuantidade em estoque: " + remedio.getQuantidade());
                    jTFQuantidade.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "A quantidade solicitada não pode ser menor ou igual a 0");
                jTFQuantidade.requestFocus();
            }
        } else {
             JOptionPane.showMessageDialog(null, "Digite a quantidade desejada");
             jTFQuantidade.requestFocus();
        }
    }//GEN-LAST:event_jBAdicionarActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (total > 0) {
            Venda venda = new Venda();

            venda.setDataVenda(LocalDate.parse(jFTFData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            venda.setDrogaria((Drogaria) jCBDrogaria.getSelectedItem());
            venda.setTotalNota(total);
            venda.setNmr_nota_fiscal(String.valueOf(new Random().nextInt(99999)));
            venda.setPagamento(jCBPagamento.getSelectedItem().toString());

            int idNovaVenda = VendaDAO.create(venda);
            System.out.println(idNovaVenda);
            for (Item item : model.getItens()) {
                item.setIdTransacao(idNovaVenda);
            }

            ItemDAO.create(model.getItens(), "venda");

            this.dispose();
        } else {
            jLInfoCompra.setText("Adicione pelo menos 1 remédio a venda");
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoverActionPerformed
        if (jTItens.getSelectedRow() != -1) {
            total -= model.getItens().get(jTItens.getSelectedRow()).getSubtotal();
            loadTotal();
            model.deleteLinha(jTItens.getSelectedRow());
        }
    }//GEN-LAST:event_jBRemoverActionPerformed

    private void jFTFDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDataFocusLost
        if (jFTFData.getText().contains("_")) {
            jLInfoData.setText("Preencha todos os digitos");
        } else {
            try {
                LocalDate data = LocalDate.parse(jFTFData.getText(), dtf);
                jLInfoData.setText("");
            } catch (DateTimeParseException e) {
                jLInfoData.setText("Data inváida!");
                loadCampoData();
                jFTFData.requestFocus();
            }
        }
    }//GEN-LAST:event_jFTFDataFocusLost

    private void jCBRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRemedioActionPerformed
        Remedio remedio = (Remedio) jCBRemedio.getSelectedItem();
        if (remedio != null) {
            jTFValorUnt.setText("R$ " + String.valueOf(remedio.getValorCusto()).replace(".", ","));
        }
    }//GEN-LAST:event_jCBRemedioActionPerformed

    public void loadDrogarias() {
        jCBDrogaria.removeAllItems();
        for (Drogaria d : DrogariaDAO.read()) {
            jCBDrogaria.addItem(d);
        }
    }

    public void loadRemedios() {
        jCBRemedio.removeAllItems();
        for (Remedio remedio : RemedioDAO.read()) {
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
            jFTFData.setFont(jCBDrogaria.getFont());
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
    private javax.swing.JComboBox<Drogaria> jCBDrogaria;
    private javax.swing.JComboBox<String> jCBPagamento;
    private javax.swing.JComboBox<Remedio> jCBRemedio;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JLabel jLInfoCompra;
    private javax.swing.JLabel jLInfoData;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFQuantidade;
    private javax.swing.JTextField jTFValorUnt;
    private javax.swing.JTable jTItens;
    // End of variables declaration//GEN-END:variables
}
