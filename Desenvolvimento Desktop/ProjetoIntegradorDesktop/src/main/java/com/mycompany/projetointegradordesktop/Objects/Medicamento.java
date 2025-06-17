package com.mycompany.projetointegradordesktop.Objects;

import java.time.LocalDate;

public class Medicamento {

    private int cod;
    private String descricao;
    private LocalDate DataUltimaCompra;
    private int quantidade;
    private double valorCusto;
    private double valorVenda;

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataUltimaCompra() {
        return DataUltimaCompra;
    }

    public void setDataUltimaCompra(LocalDate DataUltimaCompra) {
        this.DataUltimaCompra = DataUltimaCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
}
