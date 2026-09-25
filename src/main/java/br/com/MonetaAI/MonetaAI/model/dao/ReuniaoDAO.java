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

        String sql = "insert into REUNIAO(DATA, TRANSCRICAO, ID_CLIENTE) values(?, ?, ?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql, new String[]{"ID_REUNIAO"})) {
            ps.setDate(1, Date.valueOf(reuniao.getData()));
            ps.setString(2, reuniao.getTranscricao());
            ps.setInt(3, reuniao.getCliente().getIdCliente());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        reuniao.setIdReuniao(rs.getInt(1));
                    }
                }
                ConnectionFactory.fecharConexao(getCon());
                return "Reunião inserida com sucesso! ID: " + reuniao.getIdReuniao();
            }
            ConnectionFactory.fecharConexao(getCon());
            return "Não foi possível inserir a reunião.";
        } catch (SQLException e) {
            ConnectionFactory.fecharConexao(getCon());
            return "ERRO: erro de SQL " + e.getMessage();
        }
    }

    public String atualizar(ReuniaoDto reuniao){
        String sql = "update REUNIAO set DATA = ?, TRANSCRICAO = ?, ID_CLIENTE = ? WHERE ID_REUNIAO = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(reuniao.getData()));
            ps.setString(2, reuniao.getTranscricao());
            ps.setInt(3, reuniao.getCliente().getIdCliente());
            ps.setInt(4, reuniao.getIdReuniao());
            if (ps.executeUpdate() > 0) {
                ConnectionFactory.fecharConexao(getCon());
                return "Reunião foi atualizada com sucesso!";
            } else {
                ConnectionFactory.fecharConexao(getCon());
                return "Não foi possivel atualizar a reunião, id não encontrado";
            }
        } catch (SQLException e) {
            ConnectionFactory.fecharConexao(getCon());
            return "ERRO: erro de SQL" + e.getMessage();
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

    public ReuniaoDto buscarPorId(int idReuniao){
        String sql = "select ID_REUNIAO, DATA, TRANSCRICAO, ID_CLIENTE from REUNIAO where ID_REUNIAO = ?";
        Reuniao reuniao = null;
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, idReuniao);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new ClienteDAO(getCon()).buscarPorId(rs.getInt("ID_CLIENTE"));
                    reuniao = new Reuniao();
                    reuniao.setIdReuniao(rs.getInt("ID_REUNIAO"));
                    reuniao.setData(rs.getDate("DATA").toLocalDate());
                    reuniao.setTranscricao(rs.getString("TRANSCRICAO"));
                    reuniao.setCliente(cliente);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL ao buscar o ID da reunião" + e.getMessage());
        }
        ConnectionFactory.fecharConexao(getCon());
        return reuniao;
    }
}
