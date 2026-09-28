package br.com.MonetaAI.MonetaAI.model.dto;

public class FunciReuniRADto {
    private String nome;
    private String email;
    private int reunioes;
    private int pontuacao;

    public FunciReuniRADto(){}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getReunioes() {
        return reunioes;
    }
    public void setReunioes(int reunioes) {
        this.reunioes = reunioes;
    }
    public int getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
