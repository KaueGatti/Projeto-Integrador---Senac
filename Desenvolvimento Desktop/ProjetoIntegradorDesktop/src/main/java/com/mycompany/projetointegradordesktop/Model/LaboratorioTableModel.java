package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LaboratorioTableModel extends AbstractTableModel {

    List<Laboratorio> laboratorios = new ArrayList();
    String[] colunas = {"Nome", "CNPJ", "Iscrição Estadual", "Rua", "Número", "Complemento", "Bairro", "Cidade", "CEP", "Estado"};

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
                return laboratorios.get(rowIndex).getEndereco().getRua();
            case 4:
                return laboratorios.get(rowIndex).getEndereco().getNumero();
            case 5:
                return laboratorios.get(rowIndex).getEndereco().getComplemento();
            case 6:
                return laboratorios.get(rowIndex).getEndereco().getBairro();
            case 7:
                return laboratorios.get(rowIndex).getEndereco().getCidade();
            case 8:
                return laboratorios.get(rowIndex).getEndereco().getCep();
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
        }
    }

}
