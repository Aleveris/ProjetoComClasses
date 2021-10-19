package com.everis.deliveryhamburgueria.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * <ul>A classe Pedido tem as instancias da entidade id, listaProdutos, cliente e produtos.</ul>
 *
 *<ul> O id serve como uma chave primaria pra localizar no banco de dados
 *e ir gerando numeros automaticamente.</ul>
 *
 * @author Alexandre Freire da Silva <alexandre.freiresilva @ everis.nttdata.com>
 * @author Claudio Oliveira Souza <claudio.oliveirasouza @ everis.nttdata.com>
 * @author Graziele Alves Camargo <graziele.alvescamargo @ everis.nttdata.com>
 * @author Luiz Adolfo Tucunduva <luiz.adolfotucunduva @ everis.nttdata.com>
 * @author Priscilla Ribeiro Boechat <priscilla.ribeiroboechat @ everis.nttdata.com>
 * @author Roberto Sona Junior <roberto.sonajunior @ everis.nttdata.com>
 * @author Rogerio Barros Costa  <rogerio.barroscosta @ everis.nttdata.com>
 * @author Ygor Magalhaes Dias  <ygor.magalhaesdias @ everis.nttdata.com>
 * @see Produto
 * @version JDK 11
 * @since JDK 1.8
 */
@Entity
@Data
@EqualsAndHashCode(exclude="produto")
public class Pedido {

    /**
     * Essa vai ser uma chave primaria que faz um relacionamento atraves do id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String listaProdutos;
    private String cliente;

    /**
     * Relacao do banco de dados um pedido podem ter varios itens
     */
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
