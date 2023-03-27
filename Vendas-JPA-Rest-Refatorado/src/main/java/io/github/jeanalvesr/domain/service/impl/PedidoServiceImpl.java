package io.github.jeanalvesr.domain.service.impl;

import io.github.jeanalvesr.domain.repository.Pedidos;
import io.github.jeanalvesr.domain.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }


}
