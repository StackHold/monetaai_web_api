package br.com.MonetaAI.MonetaAI.model.dao;

import br.com.MonetaAI.MonetaAI.model.dto.FunciReuniRADto;
import br.com.MonetaAI.MonetaAI.model.dto.FuncionarioDto;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoDto;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoNovaDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private Connection con;

    public FuncionarioDAO(Connection con){
        this.con = con;
    }

    public Connection getCon(){
        return con;
    }

    public ArrayList<FunciReuniRADto> listarTodos(){
        String sql = "SELECT F.NOME, F.EMAIL, COUNT(DISTINCT R.ID_CLIENTE), AVG(RA.PONTUACAO)\n" +
                "FROM FUNCIONARIO F\n" +
                "INNER JOIN CONDUZ C ON F.ID_FUNCIONARIO = C.ID_FUNCIONARIO\n" +
                "INNER JOIN REUNIAO R ON C.ID_REUNIAO = R.ID_REUNIAO\n" +
                "INNER JOIN RESULTADO_ANALISE RA ON R.ID_REUNIAO = RA.ID_REUNIAO\n" +
                "GROUP BY F.NOME, F.EMAIL";
        ArrayList<FunciReuniRADto> listaFuncionario = new ArrayList<>();
        try(PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                FunciReuniRADto funciReuniRADto = new FunciReuniRADto();
                funciReuniRADto.setNome(rs.getString(1));
                funciReuniRADto.setEmail(rs.getString(2));
                funciReuniRADto.setReunioes(rs.getInt(3));
                funciReuniRADto.setPontuacao(rs.getInt(4));
                listaFuncionario.add(funciReuniRADto);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL ao listar a reunião" + e.getMessage());
        }

        return listaFuncionario;
    }



}
