package com.everis.deliveryhamburgueria.mappers;

import com.everis.deliveryhamburgueria.dtos.requests.ProdutoRequest;
import com.everis.deliveryhamburgueria.entities.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProdutoRequestToProdutoMapper {
    public Produto toEntity(ProdutoRequest produtoRequest);
    public Produto update(ProdutoRequest produtoRequest, @MappingTarget Produto produto);
}
