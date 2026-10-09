package br.com.MonetaAI.MonetaAI.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

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

    @NotNull @NotEmpty private String nome;
    @PositiveOrZero private float preco;
}
