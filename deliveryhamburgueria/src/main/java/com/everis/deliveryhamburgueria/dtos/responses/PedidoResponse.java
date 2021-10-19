package com.everis.deliveryhamburgueria.dtos.responses;

import lombok.Data;
/**
 * A classe <b>PedidoResponse</b> tem a resposta que o servidor envia ao cliente.
 * <p>No <b>PedidoResponse</b> estao os atributos id, cliente e status.</p>
 *
 * @author Alexandre Freire da Silva <alexandre.freiresilva @ everis.nttdata.com>
 * @author Claudio Oliveira Souza <claudio.oliveirasouza @ everis.nttdata.com>
 * @author Graziele Alves Camargo <graziele.alvescamargo @ everis.nttdata.com>
 * @author Luiz Adolfo Tucunduva <luiz.adolfotucunduva @ everis.nttdata.com>
 * @author Priscilla Ribeiro Boechat <priscilla.ribeiroboechat @ everis.nttdata.com>
 * @author Roberto Sona Junior <roberto.sonajunior @ everis.nttdata.com>
 * @author Rogerio Barros Costa  <rogerio.barroscosta @ everis.nttdata.com>
 * @author Ygor Magalhaes Dias  <ygor.magalhaesdias @ everis.nttdata.com>
 * @see ProdutoResponse
 * @version JDK 11
 * @since JDK 1.8
 */
@Data
public class PedidoResponse {
    private Long id;
    private String cliente;
    private String status;
}
