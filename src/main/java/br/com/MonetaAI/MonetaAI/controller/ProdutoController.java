package br.com.MonetaAI.MonetaAI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private final ProdutoService produtoService;

    @GetMapping
    public List<ProdutoPortDto> getAllProdutos(){
        return produtoService.getAllProdutos();
    }
}
