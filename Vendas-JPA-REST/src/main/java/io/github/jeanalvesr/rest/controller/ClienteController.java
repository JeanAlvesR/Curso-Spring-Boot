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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {


    private Clientes clientes;

    public ClienteController(Clientes clientes) { //O Spring sabe que é um repositório e injeta.
        this.clientes = clientes;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Integer id) {

        Optional<Cliente> cliente = clientes.findById(id);
        //ResponseEntity<Cliente> responseEntity = new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        //O que está dentro do if é basicamente o que está aqui em cima.

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get()); //Ok retorna o código 200 mais o corpo da requisição
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        cliente = clientes.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Integer id) {

        Optional<Cliente> cliente = clientes.findById(id);

        if (cliente.isPresent()) {
            clientes.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente c) {

        return clientes.findById(id).
                map(clienteExistente -> {
                    c.setId(clienteExistente.getId());
                    clientes.save(c);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());

    }


    @GetMapping("")
    @ResponseBody
    public ResponseEntity find( Cliente filtro ){

        ExampleMatcher matcher = ExampleMatcher.
                                    matching().
                                    withIgnoreCase().
                                    withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = clientes.findAll(example);
        return ResponseEntity.ok(lista);
    }


}

//    @RequestMapping(value = "/hello/{nome}", method = RequestMethod.GET)
//    @ResponseBody
//    public String helloClientes(@PathVariable("nome") String nomeCliente){
//        return String.format("Hello %s ",nomeCliente);
//    }

//    @RequestMapping(value = "/hello/{nome}",
//            method = RequestMethod.POST,
//            consumes = { "application/jason", "application/xml"},//significa que receberei requisição em Json ou XML
//            produces = { "application/jason", "application/xml"}//significa que poderei mandar tanto xml quanto jason
//    )
//    @ResponseBody
//    public Cliente helloClientes(@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente){
//        return String.format("Hello %s ",nomeCliente);
//    }

//Por padrão o Spring Boot já trabalha com Json, portanto não precisa mudar o consumes e o produces
