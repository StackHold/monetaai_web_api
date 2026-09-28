package br.com.MonetaAI.MonetaAI.model.dto;

public class ProdutoDto {
    public int getId_produto() {
        return id_produto;
    }

    public ProdutoDto() {
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    private int id_produto;
    private String nome;
    private float preco;
}
