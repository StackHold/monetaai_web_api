package br.com.MonetaAI.MonetaAI.model.dto;

public class ResultadoAnaliseDto {
    private int id_reusltado;
    private int pontuacao;
    private String classificacao;
    private String sumario;

    public ResultadoAnaliseDto(){}


    public int getId_reusltado() {
        return id_reusltado;
    }
    public void setId_reusltado(int id_reusltado) {
        this.id_reusltado = id_reusltado;
    }
    public int getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    public String getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
    public String getSumario() {
        return sumario;
    }
    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
}
