package br.com.MonetaAI.MonetaAI.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

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
    @NotNull @NotEmpty private String nome;
    @PositiveOrZero float preco;
}
