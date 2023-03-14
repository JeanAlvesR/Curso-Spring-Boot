package io.github.jeanalvesr.domain.repository;

import io.github.jeanalvesr.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer > {

    List<Cliente> findByNomeLike(String nome);

    //Personalizado

    List<Cliente> findByNomeOrId(String nome, Integer id);
    List<Cliente> findByNomeLikeOrIdOrderById(String nome, Integer id);

    Cliente findOneByNome(String nome);

    boolean existsByNome(String nome);

}