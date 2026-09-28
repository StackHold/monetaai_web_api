package br.com.MonetaAI.MonetaAI.model.dto;

public class ProdutoPortDto {

    private String nome;
    private float preco;
    private int qtdClienteCompra;
    private int qtdAparicaoReuniao;


    public ProdutoPortDto() {}

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

    public int getQtdClienteCompra() {
        return qtdClienteCompra;
    }

    public void setQtdClienteCompra(int qtdClienteCompra) {
        this.qtdClienteCompra = qtdClienteCompra;
    }

    public int getQtdAparicaoReuniao() {
        return qtdAparicaoReuniao;
    }

    public void setQtdAparicaoReuniao(int qtdAparicaoReuniao) {
        this.qtdAparicaoReuniao = qtdAparicaoReuniao;
    }


}
