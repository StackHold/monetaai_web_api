package br.com.MonetaAI.MonetaAI.service;

import br.com.MonetaAI.MonetaAI.model.dao.ConnectionFactory;
import br.com.MonetaAI.MonetaAI.model.dao.FuncionarioDAO;
import br.com.MonetaAI.MonetaAI.model.dto.FunciReuniRADto;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class FuncionarioService {

    public List<FunciReuniRADto> getTodosFuncionarios(){
        Connection con = ConnectionFactory.abrirConexao();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(con);
        List<FunciReuniRADto> result = funcionarioDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);
        return result;
    }
}
