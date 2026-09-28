package br.com.MonetaAI.MonetaAI.model.dto;

import java.time.LocalDate;

public class ReuniaoNovaDto {
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTranscricao() {
        return transcricao;
    }

    public void setTranscricao(String transcricao) {
        this.transcricao = transcricao;
    }

    private LocalDate data;
    private String transcricao;

    public ReuniaoNovaDto() {}

    public ReuniaoNovaDto(LocalDate data, String transcricao) {
        this.data = data;
        this.transcricao = transcricao;
    }
}
