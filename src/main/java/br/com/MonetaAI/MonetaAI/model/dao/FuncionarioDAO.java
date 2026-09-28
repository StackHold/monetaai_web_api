package br.com.MonetaAI.MonetaAI.model.dao;

import br.com.MonetaAI.MonetaAI.model.dto.FuncionarioDto;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoNovaDto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {
    private Connection con;

    public FuncionarioDAO(Connection con){
        this.con = con;
    }

    public Connection getCon(){
        return con;
    }

    public String inserir(FuncionarioDto funcionarioDto){
        String sql = "insert into () values()";
        try(PreparedStatement ps = getCon().prepareStatement(sql, new String[]{"ID_REUNIAO"})) {
            ps.setDate(1, Date.valueOf(.getData()));
            ps.setString(2, .getTranscricao());

            if (ps.executeUpdate() > 0) {
                return "Deu certo";
            }
            return "Não foi possível inserir a reunião.";
        } catch (SQLException e) {
            return "ERRO: erro de SQL " + e.getMessage();
        }
    }

}
