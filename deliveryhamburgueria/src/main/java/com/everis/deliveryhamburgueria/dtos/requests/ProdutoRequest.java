package com.everis.deliveryhamburgueria.dtos.requests;

import lombok.Data;

@Data
public class ProdutoRequest {
    private String nome;
    private String tipo;
    private Integer quantidadeTotal;
    private double preco;
}
