package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class CompraDAO {

    public void create(Compra c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO compra (id_compra, id_lab, id_medic, data_compra, data_entrega, nmr_nota_fiscal, total_nota, forma_pagamento, data_ultima_compra) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setDate(1, java.sql.Date.valueOf(c.getData()));
            stmt.setDate(2, java.sql.Date.valueOf(c.getEntrega()));
            stmt.setInt(3, c.getNota());
            stmt.setDouble(4, c.getTotalNota());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Falha ao Cadastrar: " + e);

        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

}
