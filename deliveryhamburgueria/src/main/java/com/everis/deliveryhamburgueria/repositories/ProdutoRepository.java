package com.everis.deliveryhamburgueria.repositories;

import com.everis.deliveryhamburgueria.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
