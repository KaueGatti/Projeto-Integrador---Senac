package com.mycompany.projetointegradordesktop.Objects;

import java.time.LocalDate;

public class Venda {
    
    private int id;
    private Drogaria drogaria;
    private LocalDate dataVenda;
    private LocalDate dataEntrega;
    private String nmr_nota_fiscal;
    private double totalNota;
    private String pagamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getNmr_nota_fiscal() {
        return nmr_nota_fiscal;
    }

    public void setNmr_nota_fiscal(String nmr_nota_fiscal) {
        this.nmr_nota_fiscal = nmr_nota_fiscal;
    }

    public double getTotalNota() {
        return totalNota;
    }

    public void setTotalNota(double totalNota) {
        this.totalNota = totalNota;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Drogaria getDrogaria() {
        return drogaria;
    }

    public void setDrogaria(Drogaria drogaria) {
        this.drogaria = drogaria;
    }
    
}
