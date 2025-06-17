package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.Objects.Medicamento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MedicamentoTableModel extends AbstractTableModel {

    List<Medicamento> medicamentos = new ArrayList();
    String[] colunas = {"Cód. do medicamento", "Descrição", "Última compra", "Quantidade", "Valor de custo", "Valor de venda"};

    @Override
    public int getRowCount() {
        return medicamentos.size();
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
                return medicamentos.get(rowIndex).getCod();
            case 1:
                return medicamentos.get(rowIndex).getDescricao();
            case 2:
                return medicamentos.get(rowIndex).getDataUltimaCompra();
            case 3:
                return medicamentos.get(rowIndex).getQuantidade();
            case 4:
                return medicamentos.get(rowIndex).getValorCusto();
            case 5:
                return medicamentos.get(rowIndex).getValorVenda();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                medicamentos.get(rowIndex).setCod(Integer.parseInt((String) value));
                break;
            case 1:
                medicamentos.get(rowIndex).setDescricao((String) value);
                break;
            case 2:
                medicamentos.get(rowIndex).setDataUltimaCompra(LocalDate.parse((String) value));
                break;
            case 3:
                medicamentos.get(rowIndex).setQuantidade(Integer.parseInt((String) value));
                break;
            case 4:
                medicamentos.get(rowIndex).setValorCusto(Double.parseDouble((String) value));
                break;
            case 5:
                medicamentos.get(rowIndex).setValorVenda(Double.parseDouble((String) value));
                break;
        }
    }

}
