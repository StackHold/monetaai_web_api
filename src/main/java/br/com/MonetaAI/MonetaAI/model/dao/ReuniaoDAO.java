package br.com.MonetaAI.MonetaAI.model.dao;

import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoDto;

import java.sql.*;
import java.util.ArrayList;

public class ReuniaoDAO {
    private Connection con;

    public ReuniaoDAO(){
        setCon(ConnectionFactory.abrirConexao());
    }

    public Connection getCon() {
        return con;
    }
    public void setCon(Connection con) {
         this.con = con;
    }

    public String inserir(ReuniaoDto reuniao){

        String sql = "insert into REUNIAO(DATA, TRANSCRICAO) values(?, ?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql, new String[]{"ID_REUNIAO"})) {
            ps.setDate(1, Date.valueOf(reuniao.getData()));
            ps.setString(2, reuniao.getTranscricao());

            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        reuniao.setId_reuniao(rs.getInt(1));
                    }
                }
                ConnectionFactory.fecharConexao(getCon());
                return "Reunião inserida com sucesso! ID: " + reuniao.getId_reuniao();
            }
            ConnectionFactory.fecharConexao(getCon());
            return "Não foi possível inserir a reunião.";
        } catch (SQLException e) {
            ConnectionFactory.fecharConexao(getCon());
            return "ERRO: erro de SQL " + e.getMessage();
        }
    }



    public String excluir(int idReuniao){
        String sql = "delete from REUNIAO where ID_REUNIAO = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, idReuniao);
            if (ps.executeUpdate() > 0) {
                ConnectionFactory.fecharConexao(getCon());
                return "A reunião foi excluida com sucesso!";
            } else {
                ConnectionFactory.fecharConexao(getCon());
                return "Não foi possivel excluir a reunião!";
            }
        } catch (SQLException e) {
            ConnectionFactory.fecharConexao(getCon());
            return "ERRO: erro de SQL" + e.getMessage();
        }
    }

    public ArrayList<ReuniaoDto> listarTodos(){
        String sql = "select * from REUNIAO order by ID_REUNIAO";
        ArrayList<ReuniaoDto> listaReuniao = new ArrayList<>();
        try(PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                ReuniaoDto reuniao = new ReuniaoDto();
                reuniao.setId_reuniao(rs.getInt("ID_REUNIAO"));
                reuniao.setData(rs.getDate("DATA").toLocalDate());
                reuniao.setTranscricao(rs.getString("TRANSCRICAO"));

                listaReuniao.add(reuniao);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL ao listar a reunião" + e.getMessage());
        }
        ConnectionFactory.fecharConexao(getCon());
        return listaReuniao;
    }


}
