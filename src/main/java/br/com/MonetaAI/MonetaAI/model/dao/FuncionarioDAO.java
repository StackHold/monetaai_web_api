package br.com.MonetaAI.MonetaAI.model.dao;

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

    public ArrayList<FuncionarioDto> listarTodos(){
        String sql = "select * from FUNCIONARIO order by ID_FUNCIONARIO";
        ArrayList<FuncionarioDto> listaFuncionario = new ArrayList<>();
        try(PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                FuncionarioDto funcionarioDto = new FuncionarioDto();
                funcionarioDto.setId_funcionario(rs.getInt(1));
                funcionarioDto.setCpf(rs.getString(2));
                funcionarioDto.setSenha(rs.getString(3));
                funcionarioDto.setNome(rs.getString(4));
                funcionarioDto.setEmail(rs.getString(5));

                listaFuncionario.add(funcionarioDto);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL ao listar a reunião" + e.getMessage());
        }

        return listaFuncionario;
    }



}
