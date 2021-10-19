package com.everis.deliveryhamburgueria.services;

import com.everis.deliveryhamburgueria.dtos.requests.PedidoRequest;
import com.everis.deliveryhamburgueria.dtos.responses.PedidoResponse;
import com.everis.deliveryhamburgueria.entities.Pedido;
import com.everis.deliveryhamburgueria.mappers.PedidoRequestToPedidoMapper;
import com.everis.deliveryhamburgueria.mappers.PedidoToPedidoResponseMapper;
import com.everis.deliveryhamburgueria.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * <p>A classe PedidoService e responsavel pela logica de negocio da aplicacao.</p>
 *
 * <p>No services foi utilizado excecao para tratar as mensagens de erros da aplicacao.</p>
 * <p>Dentre as mensagens de erros estao 500 Internal Server Error, 406 Not Acceptable, 400 Bad Request, entre outras.</p>
 * <p>E optamos por utilizar a funcao FindyById para tratar o erro 400 - Bad Request.</p>
 *
 * @author Alexandre Freire da Silva <alexandre.freiresilva @ everis.nttdata.com>
 * @author Claudio Oliveira Souza <claudio.oliveirasouza @ everis.nttdata.com>
 * @author Graziele Alves Camargo <graziele.alvescamargo @ everis.nttdata.com>
 * @author Luiz Adolfo Tucunduva <luiz.adolfotucunduva @ everis.nttdata.com>
 * @author Priscilla Ribeiro Boechat <priscilla.ribeiroboechat @ everis.nttdata.com>
 * @author Roberto Sona Junior <roberto.sonajunior @ everis.nttdata.com>
 * @author Rogerio Barros Costa  <rogerio.barroscosta @ everis.nttdata.com>
 * @author Ygor Magalhaes Dias  <ygor.magalhaesdias @ everis.nttdata.com>
 * @see ProdutoService
 * @version JDK 11
 * @since JDK 1.8
 */
@Service
@RequiredArgsConstructor
public class PedidoService {


    //Mappers
    private final PedidoRequestToPedidoMapper pedidoRequestToPedidoMapper;
    private final PedidoToPedidoResponseMapper pedidoToPedidoResponseMapper;

    //Repositories
    private final PedidoRepository pedidoRepository;

    //CadastrarPedido
    public PedidoResponse criar(PedidoRequest pedidoRequest){
        //Mapeamento
        Pedido pedido = pedidoRequestToPedidoMapper.toEntity(pedidoRequest);

        PedidoResponse pedidoResponse = new PedidoResponse();

        try {
            pedidoRepository.save(pedido);

            pedidoResponse = pedidoToPedidoResponseMapper.toDto(pedido);

            pedidoResponse.setStatus("Cadastrado com sucesso!");
        } catch (Exception e){
            pedidoResponse.setStatus("Erro ao cadastrar Pedido!");
        }

        return pedidoResponse;
    }

    //AtualizarPedido
    public PedidoResponse atualizar(Long idPedido, PedidoRequest pedidoRequest) {
        Pedido pedido = pedidoRepository.findById(idPedido).get();

        PedidoResponse pedidoResponse = new PedidoResponse();

        if (Objects.isNull(pedido)) {
            pedidoResponse.setStatus("Pedido com esse código não foi encontrado.");

            return pedidoResponse;
        }

        pedidoRequestToPedidoMapper.update(pedidoRequest, pedido);

        try {
            pedidoRepository.save(pedido);

            pedidoResponse = pedidoToPedidoResponseMapper.toDto(pedido);

            pedidoResponse.setStatus("Atualizado com sucesso!");
        } catch (Exception e) {
            pedidoResponse.setStatus("Erro ao atualizar Pedido!");
        }

        return pedidoResponse;
    }

    //ObterUmPedido
    public PedidoResponse obter(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).get();

        PedidoResponse pedidoResponse = new PedidoResponse();

        if (Objects.isNull(pedido)) {
           pedidoResponse.setStatus("Pedido com esse código não foi encontrado.");

            return pedidoResponse;

        }

       pedidoResponse = pedidoToPedidoResponseMapper.toDto(pedido);
        pedidoResponse.setStatus("Pedido obtido com sucesso do Banco de Dados");

        return pedidoResponse;

    }
    //ListarTodosPedidos
    public List<PedidoResponse> listar() {
        List<Pedido> pedidos = pedidoRepository.findAll();

        List<PedidoResponse> listaPedidosResponse = new ArrayList<>();
        pedidos
                .forEach(pedido ->  {
                    PedidoResponse pedidoResponse = pedidoToPedidoResponseMapper.toDto(pedido);
                    listaPedidosResponse.add(pedidoResponse);

                });

        return listaPedidosResponse;
    }
    //ExcluirPedido
    public PedidoResponse excluir(Long idPedido) {
        pedidoRepository.deleteById(idPedido);

        PedidoResponse pedidoResponse = new PedidoResponse();
        pedidoResponse.setStatus("Pedido excluído com sucesso.");

        return pedidoResponse;
    }

}