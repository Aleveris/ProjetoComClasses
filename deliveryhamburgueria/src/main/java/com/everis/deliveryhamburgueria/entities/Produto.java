package com.everis.deliveryhamburgueria.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
/**
 * <ul>A classe Produto tem as instancias da entidade id, nome, tipo,
 * quantidadeTotal, preco e pedido.</ul>
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
 * @see Pedido
 * @version JDK 11
 * @since JDK 1.8
 */
@Entity
@Data
public class Produto {

    /**
     * Essa vai ser uma chave primaria que faz um relacionamento atraves do id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String tipo;
    private Integer quantidadeTotal;
    private double preco;

    /**
     * Relacao do banco de dados muitos itens para um pedido
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pedido_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pedido pedido;
}
