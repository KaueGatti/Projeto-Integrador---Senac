package com.mycompany.projetointegradordesktop.Objects;

import java.time.LocalDate;

public class Compra {

    private int id;
    private Laboratorio laboratorio;
    private LocalDate dataCompra;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
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

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public double getTotalNota() {
        return totalNota;
    }

    public void setTotalNota(double totalNota) {
        this.totalNota = totalNota;
    }
}
