package br.com.MonetaAI.MonetaAI.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ClienteDto {
    private int id_cliente;
    @NotNull @NotEmpty private String cnpj;
    @NotNull @NotEmpty private String segmento;
    @NotNull  private String nome;
    @NotNull @Email private String email;

    public ClienteDto(){}

    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getSegmento() {
        return segmento;
    }
    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }
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
}
