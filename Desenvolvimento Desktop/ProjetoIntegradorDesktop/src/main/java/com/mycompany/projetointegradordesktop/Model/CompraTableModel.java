package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.Objects.Compra;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CompraTableModel extends AbstractTableModel{
    List<Compra> compras = new ArrayList();
    String[] colunas = {"Data da compra", "Data de entrega", "Nº Nota Fiscal", "Total da Nota"};

    @Override
    public int getRowCount() {
        return compras.size();
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
                return compras.get(rowIndex).getData();
            case 1:
                return compras.get(rowIndex).getEntrega();
            case 2:
                return compras.get(rowIndex).getNota();
            case 3:
                return compras.get(rowIndex).getTotalNota();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                compras.get(rowIndex).setData(LocalDate.parse((String) value));
                break;
            case 1:
                compras.get(rowIndex).setEntrega(LocalDate.parse((String) value));
                break;
            case 2:
                compras.get(rowIndex).setNota(Integer.parseInt((String) value));
                break;
            case 3:
                compras.get(rowIndex).setTotalNota(Double.parseDouble((String) value));
                break;
        }
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addLinha(Compra compra) {
        compras.add(compra);
        fireTableDataChanged();
    }
    
    public void deleteLinha(int indexLinha) {
        compras.remove(indexLinha);
        fireTableRowsDeleted(indexLinha, indexLinha);
    }
}
