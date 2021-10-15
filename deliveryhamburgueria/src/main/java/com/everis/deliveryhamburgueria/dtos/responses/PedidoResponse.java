package com.everis.deliveryhamburgueria.dtos.responses;

import lombok.Data;

@Data
public class PedidoResponse {
    private Long id;
    private String cliente;
    private String status;
}
