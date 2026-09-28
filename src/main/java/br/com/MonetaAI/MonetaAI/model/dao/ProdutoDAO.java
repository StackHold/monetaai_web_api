package br.com.MonetaAI.MonetaAI.model.dao;

import br.com.MonetaAI.MonetaAI.model.dto.ProdutoPortDto;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection con;

    public ProdutoDAO(Connection con){this.con = con;}

    public Connection getCon() {
        return con;
    }

    public List<ProdutoPortDto> listarTodos(){
        String sql = "SELECT p.nome, p.preco, COUNT(c.id_cliente), COUNT(pa.id_reuniao) from PRODUTO_TOTVS p INNER JOIN COMPRA c ON p.id_produto = c.id_produto INNER JOIN PAUTA pa ON p.id_produto = pa.id_produto GROUP BY p.nome, p.preco ORDER BY p.nome";
        ArrayList<ProdutoPortDto> listaProdutos = new ArrayList<>();
        try(PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                ProdutoPortDto produto = new ProdutoPortDto();
                produto.setNome(rs.getString(1));
                produto.setPreco(rs.getFloat(2));
                produto.setQtdClienteCompra(rs.getInt(3));
                produto.setQtdAparicaoReuniao(rs.getInt(4));

                listaProdutos.add(produto);
            }
        }catch (SQLException e){
            System.out.println("ERRO: erro de SQL ao listar a reunião" + e.getMessage());
        }
        return listaProdutos;
    }
}
