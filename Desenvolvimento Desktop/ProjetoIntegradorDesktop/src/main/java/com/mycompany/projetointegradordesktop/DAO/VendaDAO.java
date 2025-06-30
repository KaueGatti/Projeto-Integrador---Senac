package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Compra;
import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import com.mycompany.projetointegradordesktop.Objects.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VendaDAO {

    public static void create(Venda v) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL add_venda(?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, v.getDrogaria().getId());
            stmt.setDate(2, Date.valueOf(v.getDataVenda()));
            stmt.setDate(3, Date.valueOf(v.getDataEntrega()));
            stmt.setString(4, v.getNmr_nota_fiscal());
            stmt.setDouble(5, v.getTotalNota());
            stmt.setString(6, v.getPagamento());

            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public static List<Venda> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setId(rs.getInt("id_venda"));
                for (Drogaria drog : DrogariaDAO.read()) {
                    if (drog.getId() == rs.getInt("id_drog")) {
                        venda.setDrogaria(drog);
                        break;
                    }
                }
                venda.setDataVenda(LocalDate.parse(rs.getString("data_venda")));
                venda.setDataEntrega(LocalDate.parse(rs.getString("data_entrega")));
                venda.setNmr_nota_fiscal(rs.getString("nmr_nota_fiscal"));
                venda.setTotalNota(rs.getDouble("total_nota"));
                venda.setPagamento(rs.getString("forma_pagamento"));

                vendas.add(venda);
            }
            return vendas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }

    public static void update(Venda v) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL update_venda(?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, v.getId());
            stmt.setInt(2, v.getDrogaria().getId());
            stmt.setDate(3, Date.valueOf(v.getDataVenda()));
            stmt.setDate(4, Date.valueOf(v.getDataEntrega()));
            stmt.setString(5, v.getNmr_nota_fiscal());
            stmt.setDouble(6, v.getTotalNota());
            stmt.setString(7, v.getPagamento());

            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar venda: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public static void delete(Venda v) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL delete_venda(?)");

            stmt.setInt(1, v.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar venda: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}
