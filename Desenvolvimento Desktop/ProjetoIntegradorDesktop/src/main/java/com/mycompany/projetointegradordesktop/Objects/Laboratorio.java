package com.mycompany.projetointegradordesktop.Objects;

import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    
    private String nome;
    private String CNPJ;
    private String inscricaoEstadual;
    private Endereco endereco;
    private List<Medicamento> medicamentosFornecidos = new ArrayList();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Medicamento> getMedicamentosFornecidos() {
        return medicamentosFornecidos;
    }

    public void setMedicamentosFornecidos(List<Medicamento> medicamentosFornecidos) {
        this.medicamentosFornecidos = medicamentosFornecidos;
    }
    
}
