package com.everis.deliveryhamburgueria.dtos.requests;

import lombok.Data;
/**
 * <ul>A classe ProdutoRequest trabalha com atributos nome, tipo,
 quantidadeTotal e preco fazendo requisicoes para o servidor.
 * </ul>
 *
 * @author Alexandre Freire da Silva <alexandre.freiresilva @ everis.nttdata.com>
 * @author Claudio Oliveira Souza <claudio.oliveirasouza @ everis.nttdata.com>
 * @author Graziele Alves Camargo <graziele.alvescamargo @ everis.nttdata.com>
 * @author Luiz Adolfo Tucunduva <luiz.adolfotucunduva @ everis.nttdata.com>
 * @author Priscilla Ribeiro Boechat <priscilla.ribeiroboechat @ everis.nttdata.com>
 * @author Roberto Sona Junior <roberto.sonajunior @ everis.nttdata.com>
 * @author Rogerio Barros Costa  <rogerio.barroscosta @ everis.nttdata.com>
 * @author Ygor Magalhaes Dias  <ygor.magalhaesdias @ everis.nttdata.com>
 * @see PedidoRequest
 * @version JDK 11
 * @since JDK 1.8
 */
@Data
public class ProdutoRequest {
    private String nome;
    private String tipo;
    private Integer quantidadeTotal;
    private double preco;
}
