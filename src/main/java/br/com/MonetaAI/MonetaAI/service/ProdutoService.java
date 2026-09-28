package br.com.MonetaAI.MonetaAI.service;

import br.com.MonetaAI.MonetaAI.model.dao.ConnectionFactory;
import br.com.MonetaAI.MonetaAI.model.dao.ProdutoDAO;
import br.com.MonetaAI.MonetaAI.model.dto.ProdutoPortDto;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class ProdutoService {



    public List<ProdutoPortDto> getAllProdutos(){
        Connection con =  ConnectionFactory.abrirConexao();
        ProdutoDAO produtoDAO = new ProdutoDAO(con);
        List<ProdutoPortDto> resultado = produtoDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
