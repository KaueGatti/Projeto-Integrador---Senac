package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LaboratorioDAO {

    public void create(Laboratorio l) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("call add_medic()");
            stmt.setString(1, l.getCNPJ());
            stmt.setString(2, l.getInscricaoEstadual());
            stmt.setString(3, l.getNome());
            stmt.setString(4, l.getBairro());
            stmt.setString(5, l.getCidade());
            stmt.setString(6, l.getEstado());
            stmt.setString(7, l.getComplemento());
            stmt.setString(8, l.getCidade());
            stmt.setString(9, l.getNumero());
            stmt.setString(10, l.getRua());

        } catch (Exception e) {
        } finally {
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
                lab.setRua(rs.getString("rua"));
                lab.setNumero(rs.getString("numero"));
                lab.setComplemento(rs.getString("complemento"));
                lab.setBairro(rs.getString("bairro"));
                lab.setCep(rs.getString("cep"));
                lab.setEstado(rs.getString("uf"));
                
                laboratorios.add(lab);
                return laboratorios;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar laboratórios: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }

}
