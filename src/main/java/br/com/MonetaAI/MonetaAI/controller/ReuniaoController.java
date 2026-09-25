package br.com.MonetaAI.MonetaAI.controller;

import br.com.MonetaAI.MonetaAI.model.dao.ReuniaoDAO;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ReuniaoController {
    //TODO rota get listar todos

    private final ReuniaoDAO reuniaoDAO;

    ReuniaoController(ReuniaoDAO reuniaoDAO){
        this.reuniaoDAO = reuniaoDAO;
    }


    @GetMapping("/reunioes")
    public List<ReuniaoDto> getTodasReunioes(){
        return reuniaoDAO.getTodasReunioes();
    }


    //TODO rota post cadastrar nova reuniao
}
