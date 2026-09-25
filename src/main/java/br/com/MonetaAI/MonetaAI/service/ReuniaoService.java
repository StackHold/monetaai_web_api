package br.com.MonetaAI.MonetaAI.service;

import br.com.MonetaAI.MonetaAI.model.dao.ReuniaoDAO;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReuniaoService {
    private final ReuniaoDAO reuniaoDAO;

    public ReuniaoService(ReuniaoDAO reuniaoDAO) {
        this.reuniaoDAO = reuniaoDAO;
    }

    public List<ReuniaoDto> getTodasReuniao(){
        return reuniaoDAO.listarTodos();
    }

    public String postReuniao(ReuniaoDto reuniao){
        return reuniaoDAO.inserir(reuniao);
    }



}
