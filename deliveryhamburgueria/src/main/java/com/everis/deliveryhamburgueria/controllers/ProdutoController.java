package com.everis.deliveryhamburgueria.controllers;

import com.everis.deliveryhamburgueria.dtos.requests.ProdutoRequest;
import com.everis.deliveryhamburgueria.dtos.responses.ProdutoResponse;
import com.everis.deliveryhamburgueria.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A classe ProdutoController faz tarefas como o salvar, atualizar, obter,
 * listar e deletar.
 *
 * @author Alexandre Freire da Silva <alexandre.freiresilva @
 *         everis.nttdata.com>
 * @author Claudio Oliveira Souza <claudio.oliveirasouza @ everis.nttdata.com>
 * @author Graziele Alves Camargo <graziele.alvescamargo @ everis.nttdata.com>
 * @author Luiz Adolfo Tucunduva <luiz.adolfotucunduva @ everis.nttdata.com>
 * @author Priscilla Ribeiro Boechat <priscilla.ribeiroboechat @
 *         everis.nttdata.com>
 * @author Roberto Sona Junior <roberto.sonajunior @ everis.nttdata.com>
 * @author Rogerio Barros Costa <rogerio.barroscosta @ everis.nttdata.com>
 * @author Ygor Magalhaes Dias <ygor.magalhaesdias @ everis.nttdata.com>
 * @see PedidoController
 * @version JDK 11
 * @since JDK 1.8
 */

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    /**
     * <p>Esse metodo e para cadastrar o produto com POST o parametro /produto.</p>
     * <p>O cadastro do produto e feito pelo RequestMethod.POST("/produto").</p>
     * <li><b>CadastrarProduto - POST - /produto</b></li>
     * @param produtoRequest criar um produto
     * @return produtoResponse um produto criando
     */
    @PostMapping
    public ProdutoResponse salvar(@RequestBody ProdutoRequest produtoRequest){
        ProdutoResponse produtoResponse = produtoService.criar(produtoRequest);

        return produtoResponse;
    }

    /**
     * <p>Esse metodo e para atualizar o cliente com PATCH os /cliente/{id}.</p>
     * <p>A atualizacao do cliente e feito pelo RequestMethod.PATCH("/cliente")
     * <li><b>AtualizarProduto - PATCH - /produto/{id}</b></li>
     * @param idProduto a identificacao do cliente
     * @param produtoRequest atualiza um cliente
     * @return produtoRequest devolve com cliente atualizado
     */
    @PatchMapping("/{id}")
    public ProdutoResponse atualizar(@PathVariable("id") Long idProduto, @RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.atualizar(idProduto, produtoRequest);

        return produtoResponse;
    }

    /**
     * <p>Esse metodo e para obter um produto com GET com os /produto/{id}.</p>
     * <p> A obtencao do produto e feito pelo RequestMethod.GET("/produto/{id}")</p>
     * <li><b>ObterUmProduto - GET/produto/{id}</b></li>
     * @param idProduto a identificacao do produto
     * @return produtoResponse produto identificado
     */
    @GetMapping("/{id}")
    public ProdutoResponse obter(@PathVariable("id") Long idProduto){
        ProdutoResponse produtoResponse = produtoService.obter(idProduto);

        return produtoResponse;
    }

    /**
     * <p>Esse metodo e a lista composta de todos os produtos usando o GET com o /produto.</p>
     * <p>A lista do produtos e feito pelo RequestMethod.GET("/produto/")</p>
     * <li><b>>ListarTodosProdutos - GET - /produto</b></li
     * @return listaProdutosResponse trazendo todos os produto
     */
    @GetMapping
    public List<ProdutoResponse> Listar(){
        List<ProdutoResponse> listaProdutosResponse = produtoService.listar();

        return listaProdutosResponse;
    }

    /**
     * <p>Esse metodo exlui o produto usando o DELETE com o /produto/{id}.</p>
     * <p>A exclusao do produto e feito pelo RequestMethod.DELETE("/produto/{id}")</p>
     * <li><b>ExcluirProduto - DELETE - /produto/{id}</b></li>
     * @param idProduto identificacao do produto
     * @return produtoResponse identificacao do cliente
     */
    @DeleteMapping("/{id}")
    public ProdutoResponse excluir(@PathVariable("id") Long idProduto) {
        ProdutoResponse produtoResponse = produtoService.excluir(idProduto);

        return produtoResponse;
    }

}
