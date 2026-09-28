package br.com.MonetaAI.MonetaAI.controller;

import br.com.MonetaAI.MonetaAI.model.dto.FunciReuniRADto;
import br.com.MonetaAI.MonetaAI.model.dto.FuncionarioDto;
import br.com.MonetaAI.MonetaAI.service.FuncionarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionarios")
    public List<FunciReuniRADto> getTodosFuncionarios(){
        return funcionarioService.getTodosFuncionarios();
    }

}
