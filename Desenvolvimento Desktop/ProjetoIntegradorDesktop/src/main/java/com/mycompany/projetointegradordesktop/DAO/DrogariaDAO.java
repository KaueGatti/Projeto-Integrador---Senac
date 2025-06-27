package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Drogaria;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DrogariaDAO {

    public void create(Drogaria d) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("Call add_drog");
            stmt.setString(1, d.getCNPJ());
            stmt.setString(3, d.getNome());
            stmt.setString(4, d.getBairro());
            stmt.setString(5, d.getCidade());
            stmt.setString(6, d.getEstado());
            stmt.setString(7, d.getComplemento());
            stmt.setString(8, d.getCidade());
            stmt.setString(9, d.getNumero());
            stmt.setString(10, d.getRua());

        } catch (Exception e) {
        } finally {
        }
    }

}
