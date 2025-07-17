package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.Objects.Item;
import com.mycompany.projetointegradordesktop.Util.FormatadorValor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ItemTableModel extends AbstractTableModel {

    private List<Item> itens = new ArrayList();
    private String[] colunas = {"Remédio", "Quantidade", "Valor Unitário", "Subtotal"};

    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return itens.get(rowIndex).getRemedio().getDescricao();
            case 1:
                return itens.get(rowIndex).getQuantidade();
            case 2:
                return FormatadorValor.formatarValor(itens.get(rowIndex).getRemedio().getValorCusto());
            case 3:
                return FormatadorValor.formatarValor(itens.get(rowIndex).getSubtotal());
        }
        return null;
    }

    public void addLinha(Item item) {
        itens.add(item);
        fireTableDataChanged();
    }

    public void deleteLinha(int indexLinha) {
        itens.remove(indexLinha);
        fireTableRowsDeleted(indexLinha, indexLinha);
    }

    public List<Item> getItens() {
        return itens;
    }

    public void removeAllItens() {
        itens.clear();
        fireTableDataChanged();
    }
}
