package br.com.MonetaAI.MonetaAI.controller;

import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoDto;
import br.com.MonetaAI.MonetaAI.model.dto.ReuniaoNovaDto;
import br.com.MonetaAI.MonetaAI.service.ReuniaoService;
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
    public String createReuniao(@RequestBody ReuniaoNovaDto reuniao){
        return reuniaoService.postReuniao(reuniao);
    }

    @DeleteMapping("/excluindo-reuniao")
    public String deleteReuniao(@RequestBody ReuniaoDto reuniao){
        return reuniaoService.deleteReuniao(reuniao);
    }
}
