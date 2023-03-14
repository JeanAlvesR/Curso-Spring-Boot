package io.github.jeanalvesr.domain.repositorio;

import io.github.jeanalvesr.domain.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Clientes {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente) {
        entityManager.merge(cliente);
        return cliente;
    }


    @Transactional
    public void deletar(Cliente cliente) {
        if(!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);

    }

    @Transactional
    public void delelarPorId(Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
    }

    @Transactional(readOnly = true)//dizendo que essa transação é apenas leitura -> Otimiza a pesquisa
    public List<Cliente> buscarPorNome(String nome) {
        String jpql = " select c from Cliente c where c.nome like :nome ";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome","%"+nome+"%");
        return query.getResultList();
    }

    @Transactional(readOnly = true) //dizendo que essa transação é apenas leitura
    public Cliente buscarPorId(Integer id){
        return entityManager.find(Cliente.class, id);
    }

    @Transactional
    public List<Cliente> obterTodos() {
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
    }

}
