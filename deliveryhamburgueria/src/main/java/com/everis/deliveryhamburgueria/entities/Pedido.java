package com.everis.deliveryhamburgueria.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude="produto")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String listaProdutos;
    private String cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<Produto> produtos = new HashSet<>();

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;

        for (Produto b : produtos) {
            b.setPedido(this);
        }
    }
}
