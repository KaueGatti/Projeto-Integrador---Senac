package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.Objects.Remedio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RemedioTableModel extends AbstractTableModel {

    List<Remedio> remedios = new ArrayList();
    String[] colunas = {"Cód. do medicamento", "Descrição", "Última compra", "Quantidade", "Valor de custo", "Valor de venda"};

    @Override
    public int getRowCount() {
        return remedios.size();
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
                return remedios.get(rowIndex).getCod();
            case 1:
                return remedios.get(rowIndex).getDescricao();
            case 2:
                return remedios.get(rowIndex).getDataUltimaCompra();
            case 3:
                return remedios.get(rowIndex).getQuantidade();
            case 4:
                return remedios.get(rowIndex).getValorCusto();
            case 5:
                return remedios.get(rowIndex).getValorVenda();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                remedios.get(rowIndex).setCod(Integer.parseInt((String) value));
                break;
            case 1:
                remedios.get(rowIndex).setDescricao((String) value);
                break;
            case 2:
                remedios.get(rowIndex).setDataUltimaCompra(LocalDate.parse((String) value));
                break;
            case 3:
                remedios.get(rowIndex).setQuantidade(Integer.parseInt((String) value));
                break;
            case 4:
                remedios.get(rowIndex).setValorCusto(Double.parseDouble((String) value));
                break;
            case 5:
                remedios.get(rowIndex).setValorVenda(Double.parseDouble((String) value));
                break;
        }
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addLinha(Remedio remedio) {
        remedios.add(remedio);
        fireTableDataChanged();
    }
    
    public void deleteLinha(int indexLinha) {
        remedios.remove(indexLinha);
        fireTableRowsDeleted(indexLinha, indexLinha);
    }
    
    public void loadRemedios() {
        
    }

}
