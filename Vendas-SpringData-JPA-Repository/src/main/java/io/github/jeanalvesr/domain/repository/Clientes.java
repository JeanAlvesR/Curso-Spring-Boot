package io.github.jeanalvesr.domain.repository;

import io.github.jeanalvesr.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer > {

    List<Cliente> findByNomeLike(String nome);

    //Personalizado

    List<Cliente> findByNomeOrId(String nome, Integer id);

    List<Cliente> findByNomeLikeOrIdOrderById(String nome, Integer id);

    Cliente findOneByNome(String nome);

    boolean existsByNome(String nome);

    //@Query(value = " select c from Cliente c where c.nome like :nome ")
    //@Query(value = " select * from cliente where nome like CONCAT('%', :nome, '%') ", nativeQuery = true)

    @Query(value = " select * from cliente where nome like '%a%' ", nativeQuery = true)

    List<Cliente> pesquisaNomesComLetraA();
}


