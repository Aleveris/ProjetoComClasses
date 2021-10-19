package com.everis.deliveryhamburgueria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
/**
 * A classe DeliveryhamburgueriaApplication contem o Spring Application
 * que roda metodo no main().
 *
 * <ul>
 * <li>Ainda existem muitos desenvolvedores que utilizam as 3 anotacoes &#64;Configuration,
 * &#64;EnableAutoConfiguration e &#64;ComponentScan.
 * No entanto, existe uma anotacao nova, <b>&#64;SpringBootApplication</b>,
 * que esta funcionando mais rapidamente.
 * </li>
 * </ul>
 *
 *<ul><li> A anotacao <b>&#64;SpringBootApplication</b> equivale a &#64;Configuration,
 * &#64;EnableAutoConfiguration e &#64;ComponentScan com seus padroes atribuidos.
 * </li></ul>
 *
 * @author Alexandre Freire da Silva <alexandre.freiresilva @ everis.nttdata.com>
 * @author Claudio Oliveira Souza <claudio.oliveirasouza @ everis.nttdata.com>
 * @author Graziele Alves Camargo <graziele.alvescamargo @ everis.nttdata.com>
 * @author Luiz Adolfo Tucunduva <luiz.adolfotucunduva @ everis.nttdata.com>
 * @author Priscilla Ribeiro Boechat <priscilla.ribeiroboechat @ everis.nttdata.com>
 * @author Roberto Sona Junior <roberto.sonajunior @ everis.nttdata.com>
 * @author Rogerio Barros Costa  <rogerio.barroscosta @ everis.nttdata.com>
 * @author Ygor Magalhaes Dias  <ygor.magalhaesdias @ everis.nttdata.com>
 * @see SpringApplication
 * @version JDK 11
 * @since JDK 1.8
 */
@SpringBootApplication
public class DeliveryhamburgueriaApplication {

	public static void main(String[] args) {
		/** A classe SpringApplication oferece um melhor jeito de começar a aplicacao
		 * Spring, iniciando pelo metodo main().
		 * @param DeliveryhamburgueriaApplication.class o primeiro modo para carregar
		 * @param args a aplicao arguments (normalmente passada pelo método main() do Java)
		 * */
		SpringApplication.run(DeliveryhamburgueriaApplication.class, args);



	}
}
