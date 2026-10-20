package br.com.MonetaAI.MonetaAI.service;

import br.com.MonetaAI.MonetaAI.model.dao.ClienteDAO;
import br.com.MonetaAI.MonetaAI.model.dao.ConnectionFactory;
import br.com.MonetaAI.MonetaAI.model.dto.ClienteDto;
import br.com.MonetaAI.MonetaAI.model.dto.ClienteRgcDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Connection;
import java.util.List;

@Service
public class ClienteService {

    public String postCliente(ClienteDto clienteDto){
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        if (!clienteDAO.buscarPorCNPJ(clienteDto.getCnpj()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        String resultado = clienteDAO.inserir(clienteDto);
        ConnectionFactory.fecharConexao(con);
        return resultado;

    }

    public String putCliente(ClienteDto clienteDto){
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDAO clienteDao = new ClienteDAO(con);
        String resultado = clienteDao.alterar(clienteDto);
        ConnectionFactory.fecharConexao(con);
        return resultado;

    }

    public String deleteCliente(ClienteDto clienteDto){
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDAO clienteDao = new ClienteDAO(con);
        ConnectionFactory.fecharConexao(con);
        return clienteDao.excluir(clienteDto);
    }

    public List<ClienteRgcDto> getTodosClientes(){
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDAO clienteDao = new ClienteDAO(con);
        List<ClienteRgcDto> result = clienteDao.listarTodos();
        ConnectionFactory.fecharConexao(con);
        return result;
    }

}
