package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.DAO.DrogariaDAO;
import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DrogariaTableModel extends AbstractTableModel {

    List<Drogaria> drogarias = new ArrayList();
    String[] colunas = {"Nome", "CNPJ", "Número", "Rua", "CEP", "Bairro", "Cidade", "Estado", "Complemento", "Satus"};

    @Override
    public int getRowCount() {
        return drogarias.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public void setDrogarias(List<Drogaria> drogarias) {
        this.drogarias = drogarias;
        fireTableDataChanged();
    }

    public String[] getColunas() {
        return colunas;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return drogarias.get(rowIndex).getNome();
            case 1:
                return drogarias.get(rowIndex).getCNPJ();
            case 2:
                return drogarias.get(rowIndex).getNumero();
            case 3:
                return drogarias.get(rowIndex).getRua();
            case 4:
                return drogarias.get(rowIndex).getCep();
            case 5:
                return drogarias.get(rowIndex).getBairro();
            case 6:
                return drogarias.get(rowIndex).getCidade();
            case 7:
                return drogarias.get(rowIndex).getEstado();
            case 8:
                return drogarias.get(rowIndex).getComplemento();
            case 9:
                return drogarias.get(rowIndex).getStatus();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                drogarias.get(rowIndex).setNome((String) value);
                break;
            case 1:
                drogarias.get(rowIndex).setCNPJ((String) value);
                break;
            case 2:
                drogarias.get(rowIndex).setNumero((String) value);
                break;
            case 3:
                drogarias.get(rowIndex).setRua((String) value);
                break;
            case 4:
                drogarias.get(rowIndex).setCep((String) value);
                break;
            case 5:
                drogarias.get(rowIndex).setBairro((String) value);
                break;
            case 6:
                drogarias.get(rowIndex).setCidade((String) value);
                break;
            case 7:
                drogarias.get(rowIndex).setEstado((String) value);
                break;
            case 8:
                drogarias.get(rowIndex).setComplemento((String) value);
                break;
            case 9:
                drogarias.get(rowIndex).setStatus((String) value);
                break;
        }
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void addLinha(Drogaria drogaria) {
        drogarias.add(drogaria);
        fireTableDataChanged();
    }

    public void deleteLinha(int indexLinha) {
        drogarias.remove(indexLinha);
        fireTableRowsDeleted(indexLinha, indexLinha);
    }

    public List<Drogaria> getDrogarias() {
        return drogarias;
    }

    public void loadTable() {
        drogarias.clear();
        for (Drogaria drogaria : DrogariaDAO.readDinamico("", 0, null, "Ativado", null, false)) {
            drogarias.add(drogaria);
        }
        fireTableDataChanged();
    }

}
