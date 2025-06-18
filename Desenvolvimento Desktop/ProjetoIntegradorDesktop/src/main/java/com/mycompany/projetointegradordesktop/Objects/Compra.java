package com.mycompany.projetointegradordesktop.Objects;

import java.time.LocalDate;

public class Compra {
     private LocalDate data;
     private LocalDate entrega;
     private int nota;
     private double totalNota;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getEntrega() {
        return entrega;
    }

    public void setEntrega(LocalDate entrega) {
        this.entrega = entrega;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public double getTotalNota() {
        return totalNota;
    }

    public void setTotalNota(double totalNota) {
        this.totalNota = totalNota;
    }
}
