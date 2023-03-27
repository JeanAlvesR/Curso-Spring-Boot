package io.github.jeanalvesr.rest.controller;

import io.github.jeanalvesr.domain.entity.Cliente;
import io.github.jeanalvesr.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
// Conferir dentro dela, caso esqueça. Dentro tem o ResponseBody, portanto deixa o código muito mais limpo.
@RequestMapping("/api/clientes/")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) { //O Spring sabe que é um repositório e injeta.
        this.clientes = clientes;
    }

    @GetMapping("{id}")
    public Cliente getClienteById(@PathVariable("id") Integer id) {

        return clientes.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {
        return clientes.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        clientes.findById(id)
                .map(cliente -> {
                            clientes.delete(cliente);
                            return cliente;
                        }
                ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Cliente c) {

        clientes.findById(id).
                map(clienteExistente -> {
                    c.setId(clienteExistente.getId());
                    clientes.save(c);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @GetMapping
    public List<Clientes> find(Cliente filtro) {

        ExampleMatcher matcher = ExampleMatcher.
                matching().
                withIgnoreCase().
                withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);

    }
}