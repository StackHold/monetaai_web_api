package br.com.MonetaAI.MonetaAI.controller;

import br.com.MonetaAI.MonetaAI.model.dto.ProdutoPortDto;
import br.com.MonetaAI.MonetaAI.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoPortDto> getAllProdutos(){
        return produtoService.getAllProdutos();
    }
}
