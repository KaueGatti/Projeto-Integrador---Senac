package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.DAO.VendaDAO;
import com.mycompany.projetointegradordesktop.Objects.Venda;
import com.mycompany.projetointegradordesktop.Util.FormatadorValor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendaTableModel extends AbstractTableModel {

    List<Venda> vendas = new ArrayList();
    String[] colunas = {"Cliente", "Data da venda", "Data de entrega", "Nº Nota Fiscal", "Total da Nota", "Forma de Pagamento"};

    @Override
    public int getRowCount() {
        return vendas.size();
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return vendas.get(rowIndex).getDrogaria().getNome();
            case 1:
                return vendas.get(rowIndex).getDataVenda();
            case 2:
                return vendas.get(rowIndex).getDataEntrega();
            case 3:
                return vendas.get(rowIndex).getNmr_nota_fiscal();
            case 4:
                return FormatadorValor.formatarValor(vendas.get(rowIndex).getTotalNota());
            case 5:
                return vendas.get(rowIndex).getPagamento();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                vendas.get(rowIndex).getDrogaria().setNome((String) value);
                break;
            case 1:
                vendas.get(rowIndex).setDataVenda(LocalDate.parse((String) value));
                break;
            case 2:
                vendas.get(rowIndex).setDataEntrega(LocalDate.parse((String) value));
                break;
            case 3:
                vendas.get(rowIndex).setNmr_nota_fiscal((String) value);
                break;
            case 4:
                vendas.get(rowIndex).setTotalNota(Integer.parseInt((String) value));
                break;
            case 5:
                vendas.get(rowIndex).setPagamento((String) value);
                break;
        }
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void addLinha(Venda venda) {
        vendas.add(venda);
        fireTableDataChanged();
    }

    public void deleteLinha(int indexLinha) {
        vendas.remove(indexLinha);
        fireTableRowsDeleted(indexLinha, indexLinha);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void loadTable() {
        vendas.clear();
        for (Venda venda : VendaDAO.read()) {
            vendas.add(venda);
        }
        fireTableDataChanged();
    }
}
