/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegradordesktop.Model;

import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kaue.vgatti
 */
public class DrogariaTableModel extends AbstractTableModel {
    
    List<Drogaria> drogarias = new ArrayList();
    String[] colunas = {"Nome", "CNPJ", "Rua", "Número", "Complemento", "Bairro", "Cidade", "Cep", "Estado"};

    @Override
    public int getRowCount() {
        return drogarias.size();
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
                return drogarias.get(rowIndex).getNome();
            case 1:
                return drogarias.get(rowIndex).getCNPJ();
            case 2:
                return drogarias.get(rowIndex).getRua();
            case 3:
                return drogarias.get(rowIndex).getNumero();
            case 4:
                return drogarias.get(rowIndex).getComplemento();
            case 5:
                return drogarias.get(rowIndex).getBairro();
            case 6:
                return drogarias.get(rowIndex).getCidade();
            case 7:
                return drogarias.get(rowIndex).getCep();
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
        }
    }

}