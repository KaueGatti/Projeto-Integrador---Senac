package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RemedioDAO {

    public void create(Remedio remedio) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("call add_medic(?, ?, ?, ?, ?, ?);");
            stmt.setString(1, remedio.getDescricao());
            stmt.setInt(2, remedio.getCod());
            stmt.setDate(3, java.sql.Date.valueOf(remedio.getDataUltimaCompra()));
            stmt.setInt(4, remedio.getQuantidade());
            stmt.setDouble(5, remedio.getValorCusto());
            stmt.setString(6, remedio.getDescricao());
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar remédio: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

    public List<Remedio> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Remedio> remedios = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM Remedio");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Remedio remedio = new Remedio();
                remedio.setCod(rs.getInt(""));
                remedio.setDescricao(rs.getString(""));
                remedio.setQuantidade(rs.getInt(""));
                remedio.setValorCusto(rs.getDouble(""));
                remedio.setValorVenda(rs.getDouble(""));
                remedio.setDataUltimaCompra(rs.getDate("").toLocalDate());
                remedios.add(remedio);
            }
            return remedios;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar remédios: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        return null;
    }

    public void update(Remedio remedio) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("call update_remedio(?, ?, ?, ?, ?, ?);");
            stmt.setString(1, remedio.getDescricao());
            stmt.setInt(2, remedio.getCod());
            stmt.setDate(3, java.sql.Date.valueOf(remedio.getDataUltimaCompra()));
            stmt.setInt(4, remedio.getQuantidade());
            stmt.setDouble(5, remedio.getValorCusto());
            stmt.setString(6, remedio.getDescricao());
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar remédio: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

    public void delete(Remedio remedio) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("call delete_remedio(?);");
            
            stmt.setInt(1, remedio.getCod());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir remédio: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
}
