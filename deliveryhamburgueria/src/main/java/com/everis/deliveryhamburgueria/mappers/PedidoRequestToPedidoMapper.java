package com.everis.deliveryhamburgueria.mappers;

import com.everis.deliveryhamburgueria.dtos.requests.PedidoRequest;
import com.everis.deliveryhamburgueria.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
/**
 *<ul> A interface PedidoRequestToPedidoMapper funciona como um condutor de informacoes entre classes.
 * </ul>
 *
 * @author Alexandre Freire da Silva <alexandre.freiresilva @ everis.nttdata.com>
 * @author Claudio Oliveira Souza <claudio.oliveirasouza @ everis.nttdata.com>
 * @author Graziele Alves Camargo <graziele.alvescamargo @ everis.nttdata.com>
 * @author Luiz Adolfo Tucunduva <luiz.adolfotucunduva @ everis.nttdata.com>
 * @author Priscilla Ribeiro Boechat <priscilla.ribeiroboechat @ everis.nttdata.com>
 * @author Roberto Sona Junior <roberto.sonajunior @ everis.nttdata.com>
 * @author Rogerio Barros Costa  <rogerio.barroscosta @ everis.nttdata.com>
 * @author Ygor Magalhaes Dias  <ygor.magalhaesdias @ everis.nttdata.com>
 * @see PedidoToPedidoResponseMapper
 * @see ProdutoRequestToProdutoMapper
 * @see ProdutoToProdutoResponseMapper
 * @version JDK 11
 * @since JDK 1.8
 */
@Mapper(componentModel = "spring")
public interface PedidoRequestToPedidoMapper {
    public Pedido toEntity(PedidoRequest produtoRequest);
    public Pedido update(PedidoRequest produtoRequest, @MappingTarget Pedido pedido);
}
