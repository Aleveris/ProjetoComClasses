package com.everis.deliveryhamburgueria.controllers;

import com.everis.deliveryhamburgueria.dtos.requests.ProdutoRequest;
import com.everis.deliveryhamburgueria.dtos.responses.ProdutoResponse;
import com.everis.deliveryhamburgueria.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    //CadastrarProduto - POST - /produto
    @PostMapping
    public ProdutoResponse salvar(@RequestBody ProdutoRequest produtoRequest){
        ProdutoResponse produtoResponse = produtoService.criar(produtoRequest);

        return produtoResponse;
    }

    //AtualizarProduto - PATCH - /produto/{id}
    @PatchMapping("/{id}")
    public ProdutoResponse atualizar(@PathVariable("id") Long idProduto, @RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.atualizar(idProduto, produtoRequest);

        return produtoResponse;
    }
    //ObterUmProduto - GET/produto/{id}
    @GetMapping("/{id}")
    public ProdutoResponse obter(@PathVariable("id") Long idProduto){
        ProdutoResponse produtoResponse = produtoService.obter(idProduto);

        return produtoResponse;

    }
    //ListarTodosProdutos - GET - /produto
    @GetMapping
    public List<ProdutoResponse> Listar(){
        List<ProdutoResponse> listaProdutosResponse = produtoService.listar();

        return listaProdutosResponse;
    }
    //ExcluirProduto - DELETE - /produto/{id}
    @DeleteMapping("/{id}")
    public ProdutoResponse excluir(@PathVariable("id") Long idProduto) {
        ProdutoResponse produtoResponse = produtoService.excluir(idProduto);

        return produtoResponse;

    }

}
