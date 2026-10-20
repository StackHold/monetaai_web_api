package br.com.MonetaAI.MonetaAI.service;

import br.com.MonetaAI.MonetaAI.model.dao.ConnectionFactory;
import br.com.MonetaAI.MonetaAI.model.dao.ProdutoDAO;
import br.com.MonetaAI.MonetaAI.model.dto.ProdutoDto;
import br.com.MonetaAI.MonetaAI.model.dto.ProdutoNovoDto;
import br.com.MonetaAI.MonetaAI.model.dto.ProdutoPortDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public ProdutoDto createNovoProduto(ProdutoNovoDto produto){
        //TODO validar se o produto já existe na base de dados
        Connection con = ConnectionFactory.abrirConexao();
        ProdutoDAO produtoDAO = new ProdutoDAO(con);
        if (!produtoDAO.buscarPorNome(produto.getNome()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        ProdutoDto resultado = produtoDAO.criar(produto);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
