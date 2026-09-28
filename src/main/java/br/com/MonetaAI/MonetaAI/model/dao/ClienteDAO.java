package br.com.MonetaAI.MonetaAI.model.dao;

import br.com.MonetaAI.MonetaAI.model.dto.ClienteDto;
import br.com.MonetaAI.MonetaAI.model.dto.FuncionarioDto;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    private Connection con;

    public ClienteDAO(Connection con){
        this.con = con;
    }

    public Connection getcon(){
        return con;
    }

    public String inserir(ClienteDto clienteDto){
        String sql = "INSERT INTO CLIENTE(ID_CLIENTE, CNPJ, SEGMENTO, NOME, EMAIL) VALUES(?,?,?,?,?)";
        try(PreparedStatement ps = getcon().prepareStatement(sql)) {
            ps.setInt(1, clienteDto.getId_cliente());
            ps.setString(2, clienteDto.getCnpj());
            ps.setString(3, clienteDto.getSegmento());
            ps.setString(4, clienteDto.getNome());
            ps.setString(5, clienteDto.getEmail());
            if (ps.executeUpdate() > 0){
                return "Cliente inserido com sucesso!";
            }
            return "Não foi possivel inserir o cliente!";
        } catch (SQLException e) {
            return "ERRO: erro de SQL" + e.getMessage();
        }
    }

    public String alterar(ClienteDto clienteDto){
        String sql = "UPDATE CLIENTE SET CNPJ = ?, SEGMENTO = ?, NOME = ?, EMAIL = ? WHERE ID_CLIENTE = ?";
        try(PreparedStatement ps = getcon().prepareStatement(sql)) {
            ps.setString(1, clienteDto.getCnpj());
            ps.setString(2, clienteDto.getSegmento());
            ps.setString(3, clienteDto.getNome());
            ps.setString(4, clienteDto.getEmail());
            if (ps.executeUpdate() > 0){
                return "Cliente alterado com sucesso!";
            }
            return "Não foi possivel alterar o cliente!";
        } catch (SQLException e) {
            return "ERRO: erro de SQL" + e.getMessage();
        }

    }


    public String excluir(ClienteDto clienteDto){
        String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
        try(PreparedStatement ps = getcon().prepareStatement(sql)) {
            ps.setInt(1, clienteDto.getId_cliente());
            if (ps.executeUpdate() > 0){
                return "Cliente excluido com sucesso!";
            }
            return "Não foi possivel excluir o cliente!";
        } catch (SQLException e) {
            return "ERRO: erro de SQL" + e.getMessage();
        }
    }

    public ArrayList<ClienteDto> listarTodos(){
        String sql = "select * from CLIENTE order by ID_CLIENTE";
        ArrayList<ClienteDto> listaCliente = new ArrayList<>();
        try(PreparedStatement ps = getcon().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                ClienteDto clienteDto = new ClienteDto();
                clienteDto.setId_cliente(rs.getInt(1));
                clienteDto.setCnpj(rs.getString(2));
                clienteDto.setSegmento(rs.getString(3));
                clienteDto.setNome(rs.getString(4));
                clienteDto.setEmail(rs.getString(5));
                listaCliente.add(clienteDto);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL ao listar a reunião" + e.getMessage());
        }
        return listaCliente;
    }



}
