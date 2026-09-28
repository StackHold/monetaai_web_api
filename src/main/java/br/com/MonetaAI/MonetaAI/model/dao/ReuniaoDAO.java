package br.com.MonetaAI.MonetaAI.model.dao;

import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoDto;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoNovaDto;

import java.sql.*;
import java.util.ArrayList;

public class ReuniaoDAO {
    private Connection con;

    public ReuniaoDAO(Connection con){
        setCon(con);
    }

    public Connection getCon() {
        return con;
    }
    public void setCon(Connection con) {
         this.con = con;
    }

    public String inserir(ReuniaoNovaDto reuniao){

        String sql = "insert into REUNIAO_TESTE(DATA, TRANSCRICAO) values(?, ?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql, new String[]{"ID_REUNIAO"})) {
            ps.setDate(1, Date.valueOf(reuniao.getData()));
            ps.setString(2, reuniao.getTranscricao());

            if (ps.executeUpdate() > 0) {
                return "Deu certo";
            }
            return "Não foi possível inserir a reunião.";
        } catch (SQLException e) {
            return "ERRO: erro de SQL " + e.getMessage();
        }
    }



    public String excluir(int idReuniao){
        String sql = "delete from REUNIAO where ID_REUNIAO = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, idReuniao);
            if (ps.executeUpdate() > 0) {
                return "A reunião foi excluida com sucesso!";
            } else {
                return "Não foi possivel excluir a reunião!";
            }
        } catch (SQLException e) {
            return "ERRO: erro de SQL" + e.getMessage();
        }
    }

    public ArrayList<ReuniaoDto> listarTodos(){
        String sql = "select * from reuniao_teste order by ID_REUNIAO";
        ArrayList<ReuniaoDto> listaReuniao = new ArrayList<>();
        try(PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                ReuniaoDto reuniao = new ReuniaoDto();
                reuniao.setId_reuniao(rs.getInt(1));
                reuniao.setData(rs.getDate(2).toLocalDate());
                reuniao.setTranscricao(rs.getString(3));

                listaReuniao.add(reuniao);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL ao listar a reunião" + e.getMessage());
        }

        return listaReuniao;
    }


}
