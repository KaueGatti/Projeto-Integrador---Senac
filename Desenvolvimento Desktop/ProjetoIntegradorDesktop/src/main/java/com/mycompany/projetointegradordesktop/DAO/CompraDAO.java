package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Compra;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CompraDAO {

    public static void create(Compra c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL add_compra(?, ?, ?, ?, ?, ?)");
            
            stmt.setInt(1, c.getLaboratorio().getId());
            stmt.setDate(2, Date.valueOf(c.getDataCompra()));
            stmt.setDate(3, Date.valueOf(c.getDataEntrega()));
            stmt.setString(4, c.getNmr_nota_fiscal());
            stmt.setDouble(5, c.getTotalNota());
            stmt.setString(6, c.getPagamento());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar compra: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public static List<Compra> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Compra> compras = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM compra");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();

                compra.setId(rs.getInt("id_compra"));
                for (Laboratorio lab : LaboratorioDAO.read()) {
                    if (lab.getId() == rs.getInt("id_lab")) {
                        compra.setLaboratorio(lab);
                        break;
                    }
                }
                compra.setDataCompra(LocalDate.parse(rs.getString("data_compra")));
                compra.setDataEntrega(LocalDate.parse(rs.getString("data_entrega")));
                compra.setNmr_nota_fiscal(rs.getString("nmr_nota_fiscal"));
                compra.setTotalNota(rs.getDouble("total_nota"));
                compra.setPagamento(rs.getString("forma_pagamento"));

                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar compras: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }
    
    public static void update(Compra c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL update_compra(?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setInt(1, c.getId());
            stmt.setInt(2, c.getLaboratorio().getId());
            stmt.setDate(3, Date.valueOf(c.getDataCompra()));
            stmt.setDate(4, Date.valueOf(c.getDataEntrega()));
            stmt.setString(5, c.getNmr_nota_fiscal());
            stmt.setDouble(6, c.getTotalNota());
            stmt.setString(7, c.getPagamento());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar compra: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public static void delete(Compra c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL delete_compra(?)");
            
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar compra: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    

}
