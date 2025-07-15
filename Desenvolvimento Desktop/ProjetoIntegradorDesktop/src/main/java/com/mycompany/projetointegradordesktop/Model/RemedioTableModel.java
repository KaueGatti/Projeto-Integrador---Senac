package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.DAO.RemedioDAO;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import com.mycompany.projetointegradordesktop.Util.FormatadorValor;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RemedioTableModel extends AbstractTableModel {

    private List<Remedio> remedios = new ArrayList();
    private final String[] colunas = {"Laboratório", "Descrição", "Data da última compra", "Valor de custo", "Valor de venda", "Quantidade"};
    
    @Override
    public int getRowCount() {
        return remedios.size();
    }

    public String[] getColunas() {
        return colunas;
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
                return remedios.get(rowIndex).getLaboratorio().getNome();
            case 1:
                return remedios.get(rowIndex).getDescricao();
            case 2:
                if (remedios.get(rowIndex).getDataUltimaCompra() != null) {
                    return remedios.get(rowIndex).getDataUltimaCompra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                }
                break;
            case 3:
                return FormatadorValor.formatarValor(remedios.get(rowIndex).getValorCusto());
            case 4:
                return FormatadorValor.formatarValor(remedios.get(rowIndex).getValorVenda());
            case 5:
                return remedios.get(rowIndex).getQuantidade();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                remedios.get(rowIndex).setLaboratorio((Laboratorio) value);
                break;
            case 1:
                remedios.get(rowIndex).setDescricao((String) value);
                break;
            case 3:
                remedios.get(rowIndex).setValorCusto((Double) value);
                break;
            case 4:
                remedios.get(rowIndex).setValorVenda((Double) value);
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

    public List<Remedio> getRemedios() {
        return remedios;
    }
    
    public void clearTable() {
        remedios.clear();
    }

    public void setRemedios(List<Remedio> remedios) {
        this.remedios = remedios;
        fireTableDataChanged();
    }

    public void loadTable() {
        remedios.clear();
        for (Remedio remedio : RemedioDAO.read()) {
            remedios.add(remedio);
        }
        fireTableDataChanged();
    }
    
}
