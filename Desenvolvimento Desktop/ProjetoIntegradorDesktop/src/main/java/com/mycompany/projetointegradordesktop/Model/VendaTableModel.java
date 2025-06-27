package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.Objects.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendaTableModel extends AbstractTableModel{

    List<Venda> vendas = new ArrayList();
    String[] colunas = {"Nome da Drogaria"};

    @Override
    public int getRowCount() {
        return vendas.size();
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
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                vendas.get(rowIndex).getDrogaria().setNome((String) value);
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
}
