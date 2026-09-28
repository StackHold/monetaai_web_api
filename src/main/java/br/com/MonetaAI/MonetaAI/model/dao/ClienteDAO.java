package br.com.MonetaAI.MonetaAI.model.dao;

import br.com.MonetaAI.MonetaAI.model.dto.ClienteDto;
import br.com.MonetaAI.MonetaAI.model.dto.ClienteRgcDto;
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

    public ArrayList<ClienteRgcDto> listarTodos(){
        String sql = "SELECT  C.NOME, C.CNPJ, C.SEGMENTO, C.EMAIL, RGC.PONTUACAO\n" +
                "FROM CLIENTE C\n" +
                "INNER JOIN REUNIAO R ON C.ID_CLIENTE = R.ID_CLIENTE\n" +
                "INNER JOIN RESULTADO_ANALISE ra ON R.ID_REUNIAO  = ra.ID_REUNIAO \n" +
                "INNER JOIN RGC ON ra.ID_RGC = RGC.ID_RGC \n" +
                "ORDER BY RGC.PONTUACAO DESC";
        ArrayList<ClienteRgcDto> listaCliente = new ArrayList<>();
        try(PreparedStatement ps = getcon().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                ClienteRgcDto clienteRgcDto = new ClienteRgcDto();
                clienteRgcDto.setNome(rs.getString(1));
                clienteRgcDto.setCnpj(rs.getString(2));
                clienteRgcDto.setSegmento(rs.getString(3));
                clienteRgcDto.setEmail(rs.getString(4));
                clienteRgcDto.setPontuacao(rs.getInt(5));
                listaCliente.add(clienteRgcDto);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: erro de SQL ao listar a reunião" + e.getMessage());
        }
        return listaCliente;
    }



}
