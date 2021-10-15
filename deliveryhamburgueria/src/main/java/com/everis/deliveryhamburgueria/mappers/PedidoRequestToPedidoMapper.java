package com.everis.deliveryhamburgueria.mappers;

import com.everis.deliveryhamburgueria.dtos.requests.PedidoRequest;
import com.everis.deliveryhamburgueria.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PedidoRequestToPedidoMapper {
    public Pedido toEntity(PedidoRequest produtoRequest);
    public Pedido update(PedidoRequest produtoRequest, @MappingTarget Pedido pedido);
}
