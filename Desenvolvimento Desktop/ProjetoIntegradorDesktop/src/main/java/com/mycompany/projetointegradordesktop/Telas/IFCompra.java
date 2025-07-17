package com.mycompany.projetointegradordesktop.Telas;

import com.mycompany.projetointegradordesktop.DAO.CompraDAO;
import com.mycompany.projetointegradordesktop.DAO.ItemDAO;
import com.mycompany.projetointegradordesktop.DAO.LaboratorioDAO;
import com.mycompany.projetointegradordesktop.DAO.RemedioDAO;
import com.mycompany.projetointegradordesktop.DAO.VendaDAO;
import com.mycompany.projetointegradordesktop.Model.CompraTableModel;
import com.mycompany.projetointegradordesktop.Objects.Compra;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import com.mycompany.projetointegradordesktop.Util.FormatadorValor;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;

public class IFCompra extends javax.swing.JInternalFrame {

    CompraTableModel model = new CompraTableModel();

    public IFCompra() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setVisible(true);
        loadTable();
        loadLaboratorios();
        loadOrdenar();
        loadCampos();
        jBConfirmarEntrega.setEnabled(false);
        jLCompras.setIcon(new ImageIcon(getClass().getResource("/Imagens/Compra Black.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTCompra = new javax.swing.JTable();
        jBExcluirCompra = new javax.swing.JButton();
        jBNovaCompra = new javax.swing.JButton();
        jLCompras = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTFPesquisa = new javax.swing.JTextField();
        jBPesquisar = new javax.swing.JButton();
        jBFiltrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPValorTotal = new javax.swing.JPanel();
        jLValorCustoMax5 = new javax.swing.JLabel();
        jLValorCustoMax = new javax.swing.JLabel();
        jFTFValorTotalMin = new javax.swing.JFormattedTextField();
        jFTFValorTotalMax = new javax.swing.JFormattedTextField();
        jLValorCustoMax1 = new javax.swing.JLabel();
        jCBOrdenar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCBoxDesc = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jCBLaboratorio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCBPagamento = new javax.swing.JComboBox<>();
        jCBoxValorTotal = new javax.swing.JCheckBox();
        jBConfirmarEntrega = new javax.swing.JButton();

        setBorder(null);

        jTCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jTCompra.setMaximumSize(new java.awt.Dimension(100, 80));
        jTCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTCompra);

        jBExcluirCompra.setBackground(new java.awt.Color(153, 51, 0));
        jBExcluirCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBExcluirCompra.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluirCompra.setText("Excluir Compra");
        jBExcluirCompra.setBorder(null);
        jBExcluirCompra.setBorderPainted(false);
        jBExcluirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirCompraActionPerformed(evt);
            }
        });

        jBNovaCompra.setBackground(new java.awt.Color(51, 90, 15));
        jBNovaCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBNovaCompra.setForeground(new java.awt.Color(255, 255, 255));
        jBNovaCompra.setText("Nova Compra");
        jBNovaCompra.setBorder(null);
        jBNovaCompra.setBorderPainted(false);
        jBNovaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovaCompraActionPerformed(evt);
            }
        });

        jLCompras.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLCompras.setText("Compras");

        jTFPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("N° NF");

        jLValorCustoMax5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax5.setText("Min.");

        jLValorCustoMax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax.setText("Valor Total");

        jFTFValorTotalMin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jFTFValorTotalMax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLValorCustoMax1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLValorCustoMax1.setText("Máx.");

        javax.swing.GroupLayout jPValorTotalLayout = new javax.swing.GroupLayout(jPValorTotal);
        jPValorTotal.setLayout(jPValorTotalLayout);
        jPValorTotalLayout.setHorizontalGroup(
            jPValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValorTotalLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLValorCustoMax)
                .addGap(18, 18, 18)
                .addComponent(jLValorCustoMax5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValorTotalMin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLValorCustoMax1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValorTotalMax, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPValorTotalLayout.setVerticalGroup(
            jPValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValorTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValorCustoMax)
                    .addComponent(jFTFValorTotalMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFValorTotalMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValorCustoMax1)
                    .addComponent(jLValorCustoMax5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCBOrdenar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Ordenar por");

        jCBoxDesc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBoxDesc.setText("Decrescente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Laboratório");

        jCBLaboratorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Pagamento");

        jCBPagamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pix", "Débito", "Crédito", "Cheque", "Boleto" }));

        jCBoxValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBoxValorTotal.setText("Ativar");
        jCBoxValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxValorTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jCBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCBoxDesc))
                            .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jCBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBoxValorTotal)))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jCBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jCBoxValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBoxDesc))
                .addGap(12, 12, 12)
                .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jBConfirmarEntrega.setBackground(new java.awt.Color(204, 204, 204));
        jBConfirmarEntrega.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBConfirmarEntrega.setForeground(new java.awt.Color(0, 0, 0));
        jBConfirmarEntrega.setText("Confirmar Entrega");
        jBConfirmarEntrega.setBorder(null);
        jBConfirmarEntrega.setBorderPainted(false);
        jBConfirmarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfirmarEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLCompras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBConfirmarEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBNovaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jBNovaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBExcluirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBConfirmarEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLCompras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBExcluirCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirCompraActionPerformed
        if (jTCompra.getSelectedRow() != -1) {
            JFMensagemExcluir JFMensagemExcluir = new JFMensagemExcluir(new Compra());
            JFMensagemExcluir.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    if (JFMensagemExcluir.getResponse()) {
                        ItemDAO.deleteCompras(model.getCompras().get(jTCompra.getSelectedRow()));
                        CompraDAO.delete(model.getCompras().get(jTCompra.getSelectedRow()));
                        model.deleteLinha(jTCompra.getSelectedRow());
                    }
                }
            }
            );
        }
    }//GEN-LAST:event_jBExcluirCompraActionPerformed

    private void jBNovaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovaCompraActionPerformed
        IFNovaCompra IFNovaCompra = new IFNovaCompra();
        IFNovaCompra.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                model.loadTable();
            }
        }
        );
        IFNovaCompra.setSize(getDesktopPane().getSize());
        getDesktopPane().add(IFNovaCompra);
        IFNovaCompra.toFront();
    }//GEN-LAST:event_jBNovaCompraActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        model.setCompras(CompraDAO.read(jTFPesquisa.getText()));
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFiltrarActionPerformed
        String nNF = jTFPesquisa.getText();
        Laboratorio l = null;
        String pagamento = null;
        double valorTotalMin = 0;
        double valorTotalMax = 10000;
        String orderBy = null;
        boolean desc = false;

        if (jCBLaboratorio.getSelectedIndex() != 0) {
            l = (Laboratorio) jCBLaboratorio.getSelectedItem();
        }
        if (jCBPagamento.getSelectedIndex() != 0) {
            pagamento = jCBPagamento.getSelectedItem().toString();
        }
        if (jCBoxValorTotal.isSelected()) {
            valorTotalMin = ((Number) jFTFValorTotalMin.getValue()).doubleValue();
            valorTotalMax = ((Number) jFTFValorTotalMax.getValue()).doubleValue();
        }
        if (jCBOrdenar.getSelectedIndex() != 0) {
            orderBy = getOrdenar();
        }
        if (jCBoxDesc.isSelected()) {
            desc = true;
        }
        model.setCompras(CompraDAO.readDinamico(nNF, l, pagamento, valorTotalMin, valorTotalMax, orderBy, desc));
    }//GEN-LAST:event_jBFiltrarActionPerformed

    private void jCBoxValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxValorTotalActionPerformed
        if (jCBoxValorTotal.isSelected()) {
            for (Component comp : jPValorTotal.getComponents()) {
                comp.setEnabled(true);
            }
        } else {
            for (Component comp : jPValorTotal.getComponents()) {
                comp.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jCBoxValorTotalActionPerformed

    private void jTCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCompraMouseClicked
        if (jTCompra.getSelectedRow() != -1) {
            if (model.getValueAt(jTCompra.getSelectedRow(), 2).equals("Não entregue")) {
                jBConfirmarEntrega.setEnabled(true);
            } else {
                jBConfirmarEntrega.setEnabled(false);
            }
            if (evt.getClickCount() == 2) {
                JFDadosCompra JFDadosCompra = new JFDadosCompra(model.getCompras().get(jTCompra.getSelectedRow()));
            }
        }
    }//GEN-LAST:event_jTCompraMouseClicked

    private void jBConfirmarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfirmarEntregaActionPerformed
        if (jTCompra.getSelectedRow() != -1) {
            JFEntrega JFEntrega = new JFEntrega();
            JFEntrega.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    if (JFEntrega.getResponse()) {
                        model.setValueAt(JFEntrega.getData(), jTCompra.getSelectedRow(), 2);
                        CompraDAO.update(model.getCompras().get(jTCompra.getSelectedRow()));
                        jBConfirmarEntrega.setEnabled(false);
                    }
                }
            });
        }
    }//GEN-LAST:event_jBConfirmarEntregaActionPerformed

    private void loadTable() {
        jTCompra.setModel(model);
        model.loadTable();
        jTCompra.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jTCompra.setRowHeight(24);
        DefaultTableCellRenderer centralizador = new DefaultTableCellRenderer();
        centralizador.setHorizontalAlignment(SwingConstants.CENTER);
        jTCompra.getColumnModel().getColumn(1).setCellRenderer(centralizador);
        jTCompra.getColumnModel().getColumn(2).setCellRenderer(centralizador);
        jTCompra.getColumnModel().getColumn(3).setCellRenderer(centralizador);
        jTCompra.getColumnModel().getColumn(4).setCellRenderer(centralizador);
    }

    public void loadLaboratorios() {
        jCBLaboratorio.removeAllItems();
        Laboratorio l = new Laboratorio();
        l.setNome("Todos");
        jCBLaboratorio.addItem(l);
        for (Laboratorio lab : LaboratorioDAO.read()) {
            jCBLaboratorio.addItem(lab);
        }
    }

    private void loadCampos() {
        for (Component comp : jPValorTotal.getComponents()) {
            comp.setEnabled(false);
        }
        for (Component comp : jPValorTotal.getComponents()) {
            comp.setEnabled(false);
        }
        FormatadorValor.formatarCampo(jFTFValorTotalMin);
        jFTFValorTotalMin.setValue(0);
        FormatadorValor.formatarCampo(jFTFValorTotalMax);
        jFTFValorTotalMax.setValue(10000);
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
                return "id_lab";
            case 2:
                return "data_compra";
            case 3:
                return "data_entrega";
            case 4:
                return "nmr_nota_fiscal";
            case 5:
                return "total_nota";
            case 6:
                return "forma_pagamento";
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConfirmarEntrega;
    private javax.swing.JButton jBExcluirCompra;
    private javax.swing.JButton jBFiltrar;
    private javax.swing.JButton jBNovaCompra;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<Laboratorio> jCBLaboratorio;
    private javax.swing.JComboBox<String> jCBOrdenar;
    private javax.swing.JComboBox<String> jCBPagamento;
    private javax.swing.JCheckBox jCBoxDesc;
    private javax.swing.JCheckBox jCBoxValorTotal;
    private javax.swing.JFormattedTextField jFTFValorTotalMax;
    private javax.swing.JFormattedTextField jFTFValorTotalMin;
    private javax.swing.JLabel jLCompras;
    private javax.swing.JLabel jLValorCustoMax;
    private javax.swing.JLabel jLValorCustoMax1;
    private javax.swing.JLabel jLValorCustoMax5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPValorTotal;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCompra;
    private javax.swing.JTextField jTFPesquisa;
    // End of variables declaration//GEN-END:variables
}
