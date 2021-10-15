package com.everis.deliveryhamburgueria.repositories;

import com.everis.deliveryhamburgueria.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
