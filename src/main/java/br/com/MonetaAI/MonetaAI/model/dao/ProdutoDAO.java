package br.com.MonetaAI.MonetaAI.model.dao;

import br.com.MonetaAI.MonetaAI.model.dto.ProdutoPortDto;

import java.sql.Connection;
import java.util.List;

public class ProdutoDAO {
    private Connection con;

    public ProdutoDAO(Connection con){this.con = con;}

    public Connection getCon() {
        return con;
    }

    public List<ProdutoPortDto> listarTodos(){
        String sql = "SELECT p.nome, p.preco, COUNT(c.id_cliente), COUNT(pa.id_reuniao) from PRODUTO_TOTVS p INNER JOIN COMPRA c ON p.id_produto = c.id_produto INNER JOIN PAUTA pa ON p.id_produto = pa.id_produto GROUP BY p.nome, p.preco";

    }
}
