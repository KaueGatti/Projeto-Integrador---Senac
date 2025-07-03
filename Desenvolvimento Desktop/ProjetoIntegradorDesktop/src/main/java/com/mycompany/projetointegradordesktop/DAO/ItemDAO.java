package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Item;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ItemDAO {

    public static void create(List<Item> itens) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL add_item_compra(?, ?, ?)");

            for (Item item : itens) {
                stmt.setInt(1, item.getIdTransacao());
                stmt.setInt(2, item.getRemedio().getId());
                stmt.setInt(3, item.getQuantidade());
                stmt.addBatch();
            }

            stmt.executeBatch();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar itens da compra: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public static List<Item> readCompras() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Item> itens = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM item_compra");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();

                item.setId(rs.getInt("id_item_compra"));
                item.setIdTransacao(rs.getInt("id_compra"));
                for (Remedio remedio : RemedioDAO.read()) {
                    if (remedio.getId() == rs.getInt("id_remedio")) {
                        item.setRemedio(remedio);
                        break;
                    }
                }
                item.setQuantidade(rs.getInt("quantidade"));
                item.setSubtotal(item.getRemedio().getValorCusto() * item.getQuantidade());

                itens.add(item);
            }
            return itens;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar itens comprados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }
    
    public static List<Item> readVendas() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Item> itens = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM item_venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();

                item.setId(rs.getInt("id_item_venda"));
                item.setIdTransacao(rs.getInt("id_venda"));
                for (Remedio remedio : RemedioDAO.read()) {
                    if (remedio.getId() == rs.getInt("id_remedio")) {
                        item.setRemedio(remedio);
                        break;
                    }
                }
                item.setQuantidade(rs.getInt("quantidade"));
                item.setSubtotal(item.getRemedio().getValorVenda() * item.getQuantidade());

                itens.add(item);
            }
            return itens;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar itens vendidos: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }
}
