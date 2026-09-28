package br.com.MonetaAI.MonetaAI.controller;

import br.com.MonetaAI.MonetaAI.model.dto.ClienteDto;
import br.com.MonetaAI.MonetaAI.model.dto.ClienteRgcDto;
import br.com.MonetaAI.MonetaAI.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClienteController {

    private final ClienteService clienteService;

    ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping("/novo-cliente")
    public String createCliente(@RequestBody ClienteDto clienteDto){
        return clienteService.postCliente(clienteDto);
    }

    @PutMapping("/atualizar-cliente")
    public String atualizarCliente(@RequestBody ClienteDto clienteDto){
        return clienteService.putCliente(clienteDto);
    }

    @DeleteMapping("/excluindo-cliente")
    public String deleteCliente(@RequestBody ClienteDto clienteDto){
        return clienteService.deleteCliente(clienteDto);
    }

    @GetMapping("/clientes")
    public List<ClienteRgcDto> getTodosClientes(){
        return clienteService.getTodosClientes();
    }


}
