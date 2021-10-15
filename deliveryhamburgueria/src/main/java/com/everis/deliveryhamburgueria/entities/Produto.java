package com.everis.deliveryhamburgueria.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String tipo;
    private Integer quantidadeTotal;
    private double preco;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pedido_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pedido pedido;


}
