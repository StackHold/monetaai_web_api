package br.com.MonetaAI.MonetaAI.service;

import br.com.MonetaAI.MonetaAI.model.dao.ConnectionFactory;
import br.com.MonetaAI.MonetaAI.model.dao.FuncionarioDAO;
import br.com.MonetaAI.MonetaAI.model.dto.FuncionarioDto;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class FuncionarioService {

    public List<FuncionarioDto> getTodosFuncionarios(){
        Connection con = ConnectionFactory.abrirConexao();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(con);
        List<FuncionarioDto> result = funcionarioDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);
        return result;
    }
}
