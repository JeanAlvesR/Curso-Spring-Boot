package io.github.jeanalvesr.domain.repository;

import io.github.jeanalvesr.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
