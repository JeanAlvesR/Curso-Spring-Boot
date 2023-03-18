package io.github.jeanalvesr.rest.controller;


import io.github.jeanalvesr.domain.entity.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @RequestMapping(value = "/hello/{nome}", method = RequestMethod.GET)
    @ResponseBody
    public String helloClientes(@PathVariable("nome") String nomeCliente){
        return String.format("Hello %s ",nomeCliente);
    }

//    @RequestMapping(value = "/hello/{nome}",
//            method = RequestMethod.POST,
//            consumes = { "application/jason", "application/xml"},//significa que receberei requisição em Json ou XML
//            produces = { "application/jason", "application/xml"}//significa que poderei mandar tanto xml quanto jason
//    )
//    @ResponseBody
//    public Cliente helloClientes(@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente){
//        return String.format("Hello %s ",nomeCliente);
//    }

}
