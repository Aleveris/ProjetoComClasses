package com.everis.deliveryhamburgueria.controllers;


import com.everis.deliveryhamburgueria.dtos.requests.PedidoRequest;
import com.everis.deliveryhamburgueria.dtos.responses.PedidoResponse;
import com.everis.deliveryhamburgueria.entities.Pedido;
import com.everis.deliveryhamburgueria.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    //CadastrarPedido - POST - /pedido
    @PostMapping()
    public PedidoResponse salvar(@RequestBody PedidoRequest pedidoRequest){
        PedidoResponse pedidoResponse = pedidoService.criar(pedidoRequest);

        return pedidoResponse;
    }

    //AtualizarPedido - PATCH - /pedido/{id}
    @PatchMapping("/{id}")
    public PedidoResponse atualizar(@PathVariable("id") Long idPedido, @RequestBody PedidoRequest pedidoRequest) {
        PedidoResponse pedidoResponse = pedidoService.atualizar(idPedido, pedidoRequest);

        return pedidoResponse;
    }
    //ObterUmPedido - GET/pedido/{id}
    @GetMapping("/{id}")
    public PedidoResponse obter(@PathVariable("id") Long idPedido){
        PedidoResponse pedidoResponse = pedidoService.obter(idPedido);

        return pedidoResponse;

    }
    //ListarTodosPedido - GET - /pedido
    @GetMapping
    public List<PedidoResponse> Listar(){
        List<PedidoResponse> listaPedidosResponse = pedidoService.listar();

        return listaPedidosResponse;
    }
    //ExcluirPedido - DELETE - /pedido/{id}
    @DeleteMapping("/{id}")
    public PedidoResponse excluir(@PathVariable("id") Long idPedido) {
        PedidoResponse pedidoResponse = pedidoService.excluir(idPedido);

        return pedidoResponse;

    }

}
