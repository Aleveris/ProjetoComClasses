package com.everis.deliveryhamburgueria.dtos.responses;

import lombok.Data;

@Data
public class ProdutoResponse {
    private Long id;
    private String nome;
    private String tipo;
    private double preco;
    private String status;
}
