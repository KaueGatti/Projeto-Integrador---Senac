package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LaboratorioDAO {

    public static void create(Laboratorio l) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL add_lab(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, l.getNome());
            stmt.setString(2, l.getCNPJ());
            stmt.setString(3, l.getInscricaoEstadual());
            stmt.setString(4, l.getNumero());
            stmt.setString(5, l.getRua());
            stmt.setString(6, l.getCep());
            stmt.setString(7, l.getBairro());
            stmt.setString(8, l.getCidade());
            stmt.setString(9, l.getEstado());
            stmt.setString(10, l.getComplemento());

            stmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar laboratório: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public static List<Laboratorio> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Laboratorio> laboratorios = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM laboratorio");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Laboratorio lab = new Laboratorio();

                lab.setId(rs.getInt("id_lab"));
                lab.setNome(rs.getString("nome"));
                lab.setCNPJ(rs.getString("cnpj"));
                lab.setInscricaoEstadual(rs.getString("ie"));
                lab.setNumero(rs.getString("numero"));
                lab.setRua(rs.getString("rua"));
                lab.setCep(rs.getString("cep"));
                lab.setBairro(rs.getString("bairro"));
                lab.setCidade(rs.getString("cidade"));
                lab.setEstado(rs.getString("uf"));
                lab.setComplemento(rs.getString("complemento"));

                laboratorios.add(lab);
            }
            return laboratorios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar laboratórios: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }

    public static List<Laboratorio> read(String pesquisa, int tipo) {
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM laboratorio";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Laboratorio> laboratorios = new ArrayList();

        try {
            if (tipo == 0) {
                sql += " WHERE nome LIKE ?";
            } else if (tipo == 1) {
                sql += " WHERE cnpj LIKE ?";
            } else {
                sql += " WHERE ie LIKE ?";
            }

            stmt = con.prepareStatement(sql);

            stmt.setString(1, "%" + sql + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Laboratorio lab = new Laboratorio();

                lab.setId(rs.getInt("id_lab"));
                lab.setNome(rs.getString("nome"));
                lab.setCNPJ(rs.getString("cnpj"));
                lab.setInscricaoEstadual(rs.getString("ie"));
                lab.setNumero(rs.getString("numero"));
                lab.setRua(rs.getString("rua"));
                lab.setCep(rs.getString("cep"));
                lab.setBairro(rs.getString("bairro"));
                lab.setCidade(rs.getString("cidade"));
                lab.setEstado(rs.getString("uf"));
                lab.setComplemento(rs.getString("complemento"));

                laboratorios.add(lab);
            }
            return laboratorios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar laboratórios: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }

    public static List<Laboratorio> readDinamico(String pesquisa, int tipo, String estado, String orderBy, boolean isDesc) {
        Connection con = Conexao.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Laboratorio> laboratorios = new ArrayList();

        try {
            cs = con.prepareCall("CALL filterLaboratorioDinamico(?, ?, ?, ?, ?)");

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
                Laboratorio lab = new Laboratorio();

                lab.setId(rs.getInt("id_lab"));
                lab.setNome(rs.getString("nome"));
                lab.setCNPJ(rs.getString("cnpj"));
                lab.setInscricaoEstadual(rs.getString("ie"));
                lab.setNumero(rs.getString("numero"));
                lab.setRua(rs.getString("rua"));
                lab.setCep(rs.getString("cep"));
                lab.setBairro(rs.getString("bairro"));
                lab.setCidade(rs.getString("cidade"));
                lab.setEstado(rs.getString("uf"));
                lab.setComplemento(rs.getString("complemento"));

                laboratorios.add(lab);
            }
            return laboratorios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar laboratórios: " + e);
        } finally {
            Conexao.closeConnection(con, cs, rs);
        }
        return null;
    }

    public static void update(Laboratorio l) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL update_lab(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, l.getId());
            stmt.setString(2, l.getNome());
            stmt.setString(3, l.getCNPJ());
            stmt.setString(4, l.getInscricaoEstadual());
            stmt.setString(5, l.getNumero());
            stmt.setString(6, l.getRua());
            stmt.setString(7, l.getCep());
            stmt.setString(8, l.getBairro());
            stmt.setString(9, l.getCidade());
            stmt.setString(10, l.getEstado());
            stmt.setString(11, l.getComplemento());

            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar laboratório: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public static void delete(Laboratorio l) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL delete_lab(?)");

            stmt.setInt(1, l.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar laboratório: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}
