package br.com.MonetaAI.MonetaAI.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class FuncionarioDto {
    private int id_funcionario;
    @CPF private String cpf;
    @NotNull @NotEmpty private String senha;
    @NotNull @NotEmpty private String nome;
    @Email private String email;

    public FuncionarioDto(){}
    public int getId_funcionario() {
        return id_funcionario;
    }
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
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
