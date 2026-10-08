package br.com.MonetaAI.MonetaAI.model.dao;

import br.com.MonetaAI.MonetaAI.model.dto.ProdutoDto;
import br.com.MonetaAI.MonetaAI.model.dto.ProdutoNovoDto;
import br.com.MonetaAI.MonetaAI.model.dto.ProdutoPortDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpServerErrorException;

import java.sql.*;
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
            throw new HttpServerErrorException(HttpStatusCode.valueOf(500), "ERRO: erro de SQL ao listar os produtos".concat(e.getMessage()));
        }
        return listaProdutos;
    }

    public ProdutoDto criar(ProdutoNovoDto produto){
        String sql = "INSERT INTO PRODUTO_TOTVS(nome, preco) values (?,?)";
        ProdutoDto produtoResult = new ProdutoDto();
        try(PreparedStatement ps = getCon().prepareStatement(sql, new String[]{"id_produto"})){
            ps.setString(1, produto.getNome());
            ps.setFloat(2, produto.getPreco());

            if (ps.executeUpdate() > 0) {
                String queryResultado = "SELECT id_produto from PRODUTO_TOTVS where nome = ?";
                try(PreparedStatement ps2 = getCon().prepareStatement(queryResultado)){
                        ps2.setString(1, produto.getNome());
                        ResultSet rs2 = ps2.executeQuery();
                   if(rs2.next()) {
                       produtoResult.setId_produto(rs2.getInt(1));
                       produtoResult.setNome(produto.getNome());
                       produtoResult.setPreco(produto.getPreco());
                   }

                }catch (SQLException e){
                    throw new HttpServerErrorException(HttpStatusCode.valueOf(500), "erro de SQL ao listar os produtos".concat(e.getMessage()));
                }
            }

        }catch (SQLException e){
            throw new HttpServerErrorException(HttpStatusCode.valueOf(500), "erro de SQL ao listar os produtos".concat(e.getMessage()));
        }

        return produtoResult;
    }
}
