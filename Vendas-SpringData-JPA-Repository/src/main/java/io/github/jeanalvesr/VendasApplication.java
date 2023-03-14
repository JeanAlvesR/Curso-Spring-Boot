package io.github.jeanalvesr;

import io.github.jeanalvesr.domain.entity.Cliente;
import io.github.jeanalvesr.domain.entity.Produto;
import io.github.jeanalvesr.domain.repository.Clientes;
import io.github.jeanalvesr.domain.repository.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes, Produtos produtos){
        return args -> {

            System.out.println("Salvando Produto");

            produtos.save(new Produto("Camisa do Manchester United",
                    "Linda camisa do manchester united"));

            produtos.findAll().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}