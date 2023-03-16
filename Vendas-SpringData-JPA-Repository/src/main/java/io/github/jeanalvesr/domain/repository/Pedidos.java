package io.github.jeanalvesr.domain.repository;

import io.github.jeanalvesr.domain.entity.Cliente;
import io.github.jeanalvesr.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    Set<Pedido> findByCliente(Cliente cliente);
}
