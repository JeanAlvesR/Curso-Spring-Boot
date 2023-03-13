package io.github.jeanalvesr;

import io.github.jeanalvesr.domain.entity.Cliente;
import io.github.jeanalvesr.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
          clientes.salvar(new Cliente("Jean"));
          clientes.salvar(new Cliente("Naruto"));
          List<Cliente> l = clientes.obterTodos();
          //l.forEach((x)-> System.out.println(x.getNome()));
            l.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}