package com.mycompany.projetointegradordesktop.DAO;

import com.mycompany.projetointegradordesktop.DB.Conexao;
import com.mycompany.projetointegradordesktop.Objects.Laboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
            //stmt.setDouble(11, l.getMedicamentosFornecidos());

        } catch (Exception e) {
        } finally {
        }

    }

}
