package com.everis.deliveryhamburgueria.mappers;

import com.everis.deliveryhamburgueria.dtos.responses.ProdutoResponse;
import com.everis.deliveryhamburgueria.entities.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoToProdutoResponseMapper {
    public ProdutoResponse toDto(Produto produto);
}
