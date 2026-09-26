package br.com.MonetaAI.MonetaAI.service;

import br.com.MonetaAI.MonetaAI.model.dao.ConnectionFactory;
import br.com.MonetaAI.MonetaAI.model.dao.ReuniaoDAO;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoDto;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class ReuniaoService {

    public List<ReuniaoDto> getTodasReuniao(){
        Connection con = ConnectionFactory.abrirConexao();
        ReuniaoDAO reuniaoDAO = new ReuniaoDAO(con);
        List<ReuniaoDto> result = reuniaoDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);
        return result;
    }

    public String postReuniao(ReuniaoDto reuniao){
        Connection con = ConnectionFactory.abrirConexao();
        ReuniaoDAO reuniaoDAO = new ReuniaoDAO(con);
        return reuniaoDAO.inserir(reuniao);
    }

}
