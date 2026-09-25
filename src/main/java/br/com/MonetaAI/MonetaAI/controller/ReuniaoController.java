package br.com.MonetaAI.MonetaAI.controller;

import br.com.MonetaAI.MonetaAI.model.dao.ReuniaoDAO;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReuniaoController {

    private final ReuniaoService reuniaoService;

    ReuniaoController(ReuniaoService reuniaoService){
        this.reuniaoService = reuniaoService;
    }


    @GetMapping("/reunioes")
    public List<ReuniaoDto> getTodasReunioes(){
        return reuniaoService.getTodasReuniao();
    }


    @PostMapping("/nova-reuniao")
    public ReuniaoDto createReuniao(@RequestBody ReuniaoDto reuniao){
        return reuniaoService.createReuniao(reuniao);
    }
}
