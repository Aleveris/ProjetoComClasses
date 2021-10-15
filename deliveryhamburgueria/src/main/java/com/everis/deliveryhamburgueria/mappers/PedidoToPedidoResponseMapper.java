package com.everis.deliveryhamburgueria.mappers;

import com.everis.deliveryhamburgueria.dtos.responses.PedidoResponse;
import com.everis.deliveryhamburgueria.entities.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoToPedidoResponseMapper {
    public PedidoResponse toDto(Pedido pedido);
}
