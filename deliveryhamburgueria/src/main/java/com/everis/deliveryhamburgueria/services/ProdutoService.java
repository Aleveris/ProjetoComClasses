package com.everis.deliveryhamburgueria.services;

import com.everis.deliveryhamburgueria.dtos.requests.ProdutoRequest;
import com.everis.deliveryhamburgueria.dtos.responses.ProdutoResponse;
import com.everis.deliveryhamburgueria.entities.Produto;
import com.everis.deliveryhamburgueria.mappers.ProdutoRequestToProdutoMapper;
import com.everis.deliveryhamburgueria.mappers.ProdutoToProdutoResponseMapper;
import com.everis.deliveryhamburgueria.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * <p>A classe ProdutoService e responsavel pela logica de negocio da aplicacao.</p>
 *
 * <p>No services foi utilizado excecao para tratar as mensagens de erros da aplicacao.</p>
 * <p>Dentre as mensagens de erros estao 500 Internal Server Error, 406 Not Acceptable, 400 Bad Request, entre outras.</p>
 * <p>E optamos por utilizar a funcao FindyById para tratar o erro 400 - Bad Request.</p>
 *
 * @author Alexandre Freire da Silva <alexandre.freiresilva @ everis.nttdata.com>
 * @author Claudio Oliveira Souza <claudio.oliveirasouza @ everis.nttdata.com>
 * @author Graziele Alves Camargo <graziele.alvescamargo @ everis.nttdata.com>
 * @author Luiz Adolfo Tucunduva <luiz.adolfotucunduva @ everis.nttdata.com>
 * @author Priscilla Ribeiro Boechat <priscilla.ribeiroboechat @ everis.nttdata.com>
 * @author Roberto Sona Junior <roberto.sonajunior @ everis.nttdata.com>
 * @author Rogerio Barros Costa  <rogerio.barroscosta @ everis.nttdata.com>
 * @author Ygor Magalhaes Dias  <ygor.magalhaesdias @ everis.nttdata.com>
 * @see PedidoService
 * @version JDK 11
 * @since JDK 1.8
 */
@Service
@RequiredArgsConstructor
public class ProdutoService {

    //Mappers
    private final ProdutoRequestToProdutoMapper produtoRequestToProdutoMapper;
    private final ProdutoToProdutoResponseMapper produtoToProdutoResponseMapper;

    //Repositories
    private final ProdutoRepository produtoRepository;

    //CadastrarProduto
    public ProdutoResponse criar(ProdutoRequest produtoRequest){
        //Mapeamento
        Produto produto = produtoRequestToProdutoMapper.toEntity(produtoRequest);

        ProdutoResponse produtoResponse = new ProdutoResponse();

        try {
            produtoRepository.save(produto);

            produtoResponse = produtoToProdutoResponseMapper.toDto(produto);

            produtoResponse.setStatus("Cadastrado com sucesso!");
        } catch (Exception e){
            produtoResponse.setStatus("Erro ao cadastrar Produto!");
        }

        return produtoResponse;
    }

    //AtualizarProduto
    public ProdutoResponse atualizar(Long idProduto, ProdutoRequest produtoRequest) {
        Produto produto = produtoRepository.findById(idProduto).get();

        ProdutoResponse produtoResponse = new ProdutoResponse();

        if (Objects.isNull(produto)) {
            produtoResponse.setStatus("Produto com esse código não foi encontrado.");

            return produtoResponse;
        }

        produtoRequestToProdutoMapper.update(produtoRequest, produto);

        try {
            produtoRepository.save(produto);

            produtoResponse = produtoToProdutoResponseMapper.toDto(produto);

            produtoResponse.setStatus("Atualizado com sucesso!");
        } catch (Exception e) {
            produtoResponse.setStatus("Erro ao atualizar Produto!");
        }

        return produtoResponse;
    }

    //ObterUmProduto
    public ProdutoResponse obter(Long idProduto) {
       Produto produto = produtoRepository.findById(idProduto).get();

        ProdutoResponse produtoResponse = new ProdutoResponse();

        if (Objects.isNull(produto)) {
            produtoResponse.setStatus("Produto com esse código não foi encontrado.");

            return produtoResponse;

        }

        produtoResponse = produtoToProdutoResponseMapper.toDto(produto);
       produtoResponse.setStatus("Produto obtido com sucesso do Banco de Dados");

        return produtoResponse;

    }
    //ListarTodosProdutos
    public List<ProdutoResponse> listar() {
        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoResponse> listaProdutosResponse = new ArrayList<>();
        produtos
                .forEach(produto ->  {
                    ProdutoResponse produtoResponse = produtoToProdutoResponseMapper.toDto(produto);
                    listaProdutosResponse.add(produtoResponse);

                });

        return listaProdutosResponse;
    }
    //ExcluirProduto
    public ProdutoResponse excluir(Long idProduto) {
        produtoRepository.deleteById(idProduto);

        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setStatus("Produto excluído com sucesso.");

        return produtoResponse;
    }

}
