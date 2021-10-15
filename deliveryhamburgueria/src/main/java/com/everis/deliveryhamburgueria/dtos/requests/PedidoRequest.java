package com.everis.deliveryhamburgueria.dtos.requests;

import lombok.Data;

@Data
public class PedidoRequest {
    private String listaProdutos;
    private String cliente;
}
