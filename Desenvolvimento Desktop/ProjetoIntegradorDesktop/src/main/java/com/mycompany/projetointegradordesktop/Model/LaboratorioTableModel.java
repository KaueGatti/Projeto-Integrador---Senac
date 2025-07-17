package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.DAO.LaboratorioDAO;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LaboratorioTableModel extends AbstractTableModel {

    List<Laboratorio> laboratorios = new ArrayList();
    String[] colunas = {"Nome", "CNPJ", "Iscrição Estadual", "Número", "Rua", "CEP", "Bairro", "Cidade", "Estado", "Complemento", "Status"};

    @Override
    public int getRowCount() {
        return laboratorios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return laboratorios.get(rowIndex).getNome();
            case 1:
                return laboratorios.get(rowIndex).getCNPJ();
            case 2:
                return laboratorios.get(rowIndex).getInscricaoEstadual();
            case 3:
                return laboratorios.get(rowIndex).getNumero();
            case 4:
                return laboratorios.get(rowIndex).getRua();
            case 5:
                return laboratorios.get(rowIndex).getCep();
            case 6:
                return laboratorios.get(rowIndex).getBairro();
            case 7:
                return laboratorios.get(rowIndex).getCidade();
            case 8:
                return laboratorios.get(rowIndex).getEstado();
            case 9:
                return laboratorios.get(rowIndex).getComplemento();
            case 10:
                return laboratorios.get(rowIndex).getStatus();

        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                laboratorios.get(rowIndex).setNome((String) value);
                break;
            case 1:
                laboratorios.get(rowIndex).setCNPJ((String) value);
                break;
            case 2:
                laboratorios.get(rowIndex).setInscricaoEstadual((String) value);
                break;
            case 3:
                laboratorios.get(rowIndex).setNumero((String) value);
                break;
            case 4:
                laboratorios.get(rowIndex).setRua((String) value);
                break;
            case 5:
                laboratorios.get(rowIndex).setCep((String) value);
                break;
            case 6:
                laboratorios.get(rowIndex).setBairro((String) value);
                break;
            case 7:
                laboratorios.get(rowIndex).setCidade((String) value);
                break;
            case 8:
                laboratorios.get(rowIndex).setEstado((String) value);
                break;
            case 9:
                laboratorios.get(rowIndex).setComplemento((String) value);
                break;
            case 10:
                laboratorios.get(rowIndex).setStatus((String) value);
                break;
        }
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void addLinha(Laboratorio laboratorio) {
        laboratorios.add(laboratorio);
        fireTableDataChanged();
    }

    public void deleteLinha(int indexLinha) {
        laboratorios.remove(indexLinha);
        fireTableRowsDeleted(indexLinha, indexLinha);
    }
    
    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }
    
    public void loadTable() {
        laboratorios.clear();
        for (Laboratorio lab: LaboratorioDAO.readDinamico("", 0, null, "Ativado", null, false)) {
            laboratorios.add(lab);
        }
        fireTableDataChanged();
    }
}
