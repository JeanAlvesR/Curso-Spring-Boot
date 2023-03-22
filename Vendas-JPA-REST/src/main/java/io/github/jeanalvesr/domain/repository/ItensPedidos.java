package io.github.jeanalvesr.domain.repository;

import io.github.jeanalvesr.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidos extends JpaRepository<ItemPedido, Integer> {
}
