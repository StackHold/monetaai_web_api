package br.com.MonetaAI.MonetaAI.model.dto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReuniaoDto {
    private int id_reuniao;
    private LocalDate data;
    private String transcricao;

    public ReuniaoDto() {}

    public int getId_reuniao() {
        return id_reuniao;
    }
    public void setId_reuniao(int id_reuniao) {
        this.id_reuniao = id_reuniao;
    }
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
}
