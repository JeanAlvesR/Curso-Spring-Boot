package io.github.jeanalvesr.service;

import io.github.jeanalvesr.model.Cliente;
import io.github.jeanalvesr.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {
    //Não precisa
    //@Autowired -> Dá para injetar via construtor, direto no atributo ou via método set ;
    //private ClientesRepository repository
    private ClientesRepository repository;
    @Autowired
    public ClientesService(ClientesRepository repository){
        this.repository = repository;
    }
    public void salveCliente(Cliente cliente){
        validarCliente(cliente);
        repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //Aplica Validações
    }
}
