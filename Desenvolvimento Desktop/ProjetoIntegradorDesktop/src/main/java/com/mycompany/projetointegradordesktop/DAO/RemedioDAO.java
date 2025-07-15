package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import com.mycompany.projetointegradordesktop.Objects.Remedio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RemedioDAO {

    public static void create(Remedio remedio) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL add_remedio(?, ?, ?, ?)");

            stmt.setInt(1, remedio.getLaboratorio().getId());
            stmt.setString(2, remedio.getDescricao());
            stmt.setDouble(3, remedio.getValorCusto());
            stmt.setDouble(4, remedio.getValorVenda());

            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar remédio: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public static List<Remedio> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Remedio> remedios = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM remedio");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Remedio remedio = new Remedio();

                remedio.setId(rs.getInt("id_remedio"));
                for (Laboratorio lab : LaboratorioDAO.read()) {
                    if (lab.getId() == rs.getInt("id_lab")) {
                        remedio.setLaboratorio(lab);
                        break;
                    }
                }
                remedio.setDescricao(rs.getString("descricao"));
                if (rs.getDate("data_ultima_compra") != null) {
                    remedio.setDataUltimaCompra(rs.getDate("data_ultima_compra").toLocalDate());
                }
                remedio.setValorCusto(rs.getDouble("valor_custo"));
                remedio.setValorVenda(rs.getDouble("valor_venda"));
                remedio.setQuantidade(rs.getInt("qntd_armazenada"));

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

    public static List<Remedio> read(Laboratorio l) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Remedio> remedios = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM remedio WHERE id_lab = ?");

            stmt.setInt(1, l.getId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                Remedio remedio = new Remedio();

                remedio.setId(rs.getInt("id_remedio"));
                for (Laboratorio lab : LaboratorioDAO.read()) {
                    if (lab.getId() == rs.getInt("id_lab")) {
                        remedio.setLaboratorio(lab);
                        break;
                    }
                }
                remedio.setDescricao(rs.getString("descricao"));
                if (rs.getDate("data_ultima_compra") != null) {
                    remedio.setDataUltimaCompra(rs.getDate("data_ultima_compra").toLocalDate());
                }
                remedio.setValorCusto(rs.getDouble("valor_custo"));
                remedio.setValorVenda(rs.getDouble("valor_venda"));
                remedio.setQuantidade(rs.getInt("qntd_armazenada"));

                remedios.add(remedio);
            }

            return remedios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar remédios por laboratório: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        return null;
    }

    public static List<Remedio> read(String descricao) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Remedio> remedios = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM remedio WHERE descricao LIKE ?");

            stmt.setString(1, "%" + descricao + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Remedio remedio = new Remedio();

                remedio.setId(rs.getInt("id_remedio"));
                for (Laboratorio lab : LaboratorioDAO.read()) {
                    if (lab.getId() == rs.getInt("id_lab")) {
                        remedio.setLaboratorio(lab);
                        break;
                    }
                }
                remedio.setDescricao(rs.getString("descricao"));
                if (rs.getDate("data_ultima_compra") != null) {
                    remedio.setDataUltimaCompra(rs.getDate("data_ultima_compra").toLocalDate());
                }
                remedio.setValorCusto(rs.getDouble("valor_custo"));
                remedio.setValorVenda(rs.getDouble("valor_venda"));
                remedio.setQuantidade(rs.getInt("qntd_armazenada"));

                remedios.add(remedio);
            }

            return remedios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar remédios pela descrição: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        return null;
    }

    public static List<Remedio> read(String descricao, Laboratorio l) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Remedio> remedios = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM remedio WHERE descricao LIKE ? AND id_lab = ?");

            stmt.setString(1, "%" + descricao + "%");
            stmt.setInt(2, l.getId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                Remedio remedio = new Remedio();

                remedio.setId(rs.getInt("id_remedio"));
                for (Laboratorio lab : LaboratorioDAO.read()) {
                    if (lab.getId() == rs.getInt("id_lab")) {
                        remedio.setLaboratorio(lab);
                        break;
                    }
                }
                remedio.setDescricao(rs.getString("descricao"));
                if (rs.getDate("data_ultima_compra") != null) {
                    remedio.setDataUltimaCompra(rs.getDate("data_ultima_compra").toLocalDate());
                }
                remedio.setValorCusto(rs.getDouble("valor_custo"));
                remedio.setValorVenda(rs.getDouble("valor_venda"));
                remedio.setQuantidade(rs.getInt("qntd_armazenada"));

                remedios.add(remedio);
            }

            return remedios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar remédios pela descrição: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        return null;
    }

    public static List<Remedio> read(String descricao, Laboratorio l,
            double valorCustoMin, double valorCustoMax,
            double valorVendaMin, double valorVendaMax) {

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Remedio> remedios = new ArrayList();

        try {
            stmt = con.prepareStatement("CALL filterRemedio(?, ?, ?, ?, ?, ?)");

            stmt.setString(1, "%" + descricao + "%");
            stmt.setInt(2, l.getId());
            stmt.setDouble(3, valorCustoMin);
            stmt.setDouble(4, valorCustoMax);
            stmt.setDouble(5, valorVendaMin);
            stmt.setDouble(6, valorVendaMax);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Remedio remedio = new Remedio();

                remedio.setId(rs.getInt("id_remedio"));
                for (Laboratorio lab : LaboratorioDAO.read()) {
                    if (lab.getId() == rs.getInt("id_lab")) {
                        remedio.setLaboratorio(lab);
                        break;
                    }
                }
                remedio.setDescricao(rs.getString("descricao"));
                if (rs.getDate("data_ultima_compra") != null) {
                    remedio.setDataUltimaCompra(rs.getDate("data_ultima_compra").toLocalDate());
                }
                remedio.setValorCusto(rs.getDouble("valor_custo"));
                remedio.setValorVenda(rs.getDouble("valor_venda"));
                remedio.setQuantidade(rs.getInt("qntd_armazenada"));

                remedios.add(remedio);
            }

            return remedios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar remédios pela descrição: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        return null;
    }
    
    public static List<Remedio> read(String descricao,
            double valorCustoMin, double valorCustoMax,
            double valorVendaMin, double valorVendaMax) {

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Remedio> remedios = new ArrayList();

        try {
            stmt = con.prepareStatement("CALL filterRemedioValor(?, ?, ?, ?, ?)");

            stmt.setString(1, "%" + descricao + "%");
            stmt.setDouble(2, valorCustoMin);
            stmt.setDouble(3, valorCustoMax);
            stmt.setDouble(4, valorVendaMin);
            stmt.setDouble(5, valorVendaMax);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Remedio remedio = new Remedio();

                remedio.setId(rs.getInt("id_remedio"));
                for (Laboratorio lab : LaboratorioDAO.read()) {
                    if (lab.getId() == rs.getInt("id_lab")) {
                        remedio.setLaboratorio(lab);
                        break;
                    }
                }
                remedio.setDescricao(rs.getString("descricao"));
                if (rs.getDate("data_ultima_compra") != null) {
                    remedio.setDataUltimaCompra(rs.getDate("data_ultima_compra").toLocalDate());
                }
                remedio.setValorCusto(rs.getDouble("valor_custo"));
                remedio.setValorVenda(rs.getDouble("valor_venda"));
                remedio.setQuantidade(rs.getInt("qntd_armazenada"));

                remedios.add(remedio);
            }

            return remedios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar remédios pela descrição: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        return null;
    }

    public static void update(Remedio remedio) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL update_remedio(?, ?, ?, ?, ?)");

            stmt.setInt(1, remedio.getId());
            stmt.setInt(2, remedio.getLaboratorio().getId());
            stmt.setString(3, remedio.getDescricao());
            stmt.setDouble(4, remedio.getValorCusto());
            stmt.setDouble(5, remedio.getValorVenda());

            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar remédio: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public static int delete(Remedio remedio) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CALL delete_remedio(?)");

            stmt.setInt(1, remedio.getId());

            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir remédio: Existem compras/vendas vinculadas a este remédio");
            System.out.println(e);
            return 0;
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}
