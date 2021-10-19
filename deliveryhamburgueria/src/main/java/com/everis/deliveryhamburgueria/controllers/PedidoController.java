package com.everis.deliveryhamburgueria.controllers;

import com.everis.deliveryhamburgueria.dtos.requests.PedidoRequest;
import com.everis.deliveryhamburgueria.dtos.responses.PedidoResponse;
import com.everis.deliveryhamburgueria.entities.Pedido;
import com.everis.deliveryhamburgueria.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A classe PedidoController faz tarefas como o salvar, atualizar, obter,
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
 * @see ProdutoController
 * @version JDK 11
 * @since JDK 1.8
 */

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    /**
     * <p>Esse metodo e para cadastrar o pedido com POST o parametro /pedido.</p>
     * <p>O cadastro do pedido e feito pelo RequestMethod.POST("/pedido").</p>
     * <li><b>CadastrarPedido - POST - /pedido</b></li>
     * @param pedidoRequest criar um pedido
     * @return pedidoResponse pedido criando
     */
    @PostMapping
    public PedidoResponse salvar(@RequestBody PedidoRequest pedidoRequest){
        PedidoResponse pedidoResponse = pedidoService.criar(pedidoRequest);

        return pedidoResponse;
    }

    /**
     * <p>Esse metodo e para atualizar o pedido com PATCH os /cliente/{id}.</p>
     * <p>A atualizacao do pedido e feito pelo RequestMethod.PATCH("/cliente")
     * <li><b>//AtualizarPedido - PATCH - /pedido/{id}</b></li>
     * @param idPedido a identificacao do cliente
     * @param pedidoRequest atualiza o pedido
     * @return pedidoResponse devolve com pedido atualizado
     */
    @PatchMapping("/{id}")
    public PedidoResponse atualizar(@PathVariable("id") Long idPedido, @RequestBody PedidoRequest pedidoRequest) {
        PedidoResponse pedidoResponse = pedidoService.atualizar(idPedido, pedidoRequest);

        return pedidoResponse;
    }

    /**
     * <p>Esse metodo e para obter um pedido com GET com os /pedido/{id}.</p>
     * <p> A obtencao do pedido e feito pelo RequestMethod.GET("/pedido/{id}")</p>
     * <li><b>ObterUmPedido - GET/pedido/{id}</b></li>
     * @param idPedido a identificacao do pedido
     * @return pedidoResponse pedido identificado
     */
    @GetMapping("/{id}")
    public PedidoResponse obter(@PathVariable("id") Long idPedido){
        PedidoResponse pedidoResponse = pedidoService.obter(idPedido);

        return pedidoResponse;
    }

    /**
     * <p>Esse metodo e a lista composta de todos os pedidos usando o GET com o /produto.</p>
     * <p>A lista do pedido e feito pelo RequestMethod.GET("/pedido/")</p>
     * <li><b>ListarTodosPedido - GET - /pedido</b></li>
     * @return listaPedidosResponse trazendo todos os pedidos
     */
    @GetMapping
    public List<PedidoResponse> Listar(){
        List<PedidoResponse> listaPedidosResponse = pedidoService.listar();

        return listaPedidosResponse;
    }

    /**
     * <p>Esse metodo exlui o pedido usando o DELETE com o /pedido/{id}.</p>
     * <p>A exclusao do pedido e feito pelo RequestMethod.DELETE("/pedido/{id}")</p>
     * <li><b>ExcluirPedido - DELETE - /pedido/{id}</b></li>
     * @param idPedido identificacao do pedido
     * @return pedidoResponse exclusao do pedido
     */
    @DeleteMapping("/{id}")
    public PedidoResponse excluir(@PathVariable("id") Long idPedido) {
        PedidoResponse pedidoResponse = pedidoService.excluir(idPedido);

        return pedidoResponse;

    }

}
