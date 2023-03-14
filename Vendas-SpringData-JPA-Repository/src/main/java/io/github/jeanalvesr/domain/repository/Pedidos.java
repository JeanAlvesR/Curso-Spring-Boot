package io.github.jeanalvesr.domain.repository;

import io.github.jeanalvesr.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
