package io.github.jeanalvesr;

import io.github.jeanalvesr.domain.entity.Cliente;
import io.github.jeanalvesr.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Eren"));
            clientes.save(new Cliente("Outro Cliente"));

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Testando se existe o Eren: "+clientes.existsByNome("Eren") );
        };
    }



    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}