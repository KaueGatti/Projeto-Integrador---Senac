package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DrogariaDAO {

    public static void create(Drogaria d) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL add_drog(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getCNPJ());
            stmt.setString(3, d.getNumero());
            stmt.setString(4, d.getRua());
            stmt.setString(5, d.getCep());
            stmt.setString(6, d.getBairro());
            stmt.setString(7, d.getCidade());
            stmt.setString(8, d.getEstado());
            stmt.setString(9, d.getComplemento());
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar drogaria: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public static List<Drogaria> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Drogaria> drogarias = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM drogaria");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Drogaria drogaria = new Drogaria();

                drogaria.setId(rs.getInt("id_drog"));
                drogaria.setNome(rs.getString("nome"));
                drogaria.setCNPJ(rs.getString("cnpj"));
                drogaria.setNumero(rs.getString("numero"));
                drogaria.setRua(rs.getString("rua"));
                drogaria.setCep(rs.getString("cep"));
                drogaria.setBairro(rs.getString("bairro"));
                drogaria.setCidade(rs.getString("cidade"));
                drogaria.setEstado(rs.getString("uf"));
                drogaria.setComplemento(rs.getString("complemento"));

                drogarias.add(drogaria);
            }
            return drogarias;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar drogarias: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }
    
    public static List<Drogaria> readDinamico(String pesquisa, int tipo, String estado, String orderBy, boolean isDesc) {
        Connection con = Conexao.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Drogaria> drogarias = new ArrayList();

        try {
            cs = con.prepareCall("CALL filterDrogariaDinamico(?, ?, ?, ?, ?)");
            
            cs.setString(1, "%" + pesquisa + "%");
            cs.setInt(2, tipo);

            if (estado != null) {
                cs.setString(3, estado);
            } else {
                cs.setNull(3, Types.VARCHAR);
            }

            if (orderBy != null) {
                cs.setString(4, orderBy);
            } else {
                cs.setNull(4, Types.VARCHAR);
            }
            
            cs.setBoolean(5, isDesc);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                Drogaria drogaria = new Drogaria();

                drogaria.setId(rs.getInt("id_drog"));
                drogaria.setNome(rs.getString("nome"));
                drogaria.setCNPJ(rs.getString("cnpj"));
                drogaria.setNumero(rs.getString("numero"));
                drogaria.setRua(rs.getString("rua"));
                drogaria.setCep(rs.getString("cep"));
                drogaria.setBairro(rs.getString("bairro"));
                drogaria.setCidade(rs.getString("cidade"));
                drogaria.setEstado(rs.getString("uf"));
                drogaria.setComplemento(rs.getString("complemento"));

                drogarias.add(drogaria);
            }
            return drogarias;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar drogarias: " + e);
        } finally {
            Conexao.closeConnection(con, cs, rs);
        }
        return null;
    }
    
    public static void update(Drogaria d) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL update_drog(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setInt(1, d.getId());
            stmt.setString(2, d.getNome());
            stmt.setString(3, d.getCNPJ());
            stmt.setString(4, d.getNumero());
            stmt.setString(5, d.getRua());
            stmt.setString(6, d.getCep());
            stmt.setString(7, d.getBairro());
            stmt.setString(8, d.getCidade());
            stmt.setString(9, d.getEstado());
            stmt.setString(10, d.getComplemento());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar drogaria: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public static void delete(Drogaria d) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL delete_drog(?)");
            
            stmt.setInt(1, d.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar drogaria: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
}
