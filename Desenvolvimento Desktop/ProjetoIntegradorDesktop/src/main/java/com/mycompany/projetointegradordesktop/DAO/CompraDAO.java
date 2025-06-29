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
            stmt = con.prepareStatement("");

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Falha ao Cadastrar: " + e);

        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

}
