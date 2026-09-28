package br.com.MonetaAI.MonetaAI.model.dto;

public class ProdutoNovoDto {
    public String getNome() {
        return nome;
    }

    public ProdutoNovoDto() {
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

    private String nome;
    private float preco;
}
