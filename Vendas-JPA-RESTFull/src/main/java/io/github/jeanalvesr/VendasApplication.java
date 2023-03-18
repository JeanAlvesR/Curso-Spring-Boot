package io.github.jeanalvesr;

import io.github.jeanalvesr.domain.entity.Cliente;
import io.github.jeanalvesr.domain.entity.Pedido;
import io.github.jeanalvesr.domain.entity.Produto;
import io.github.jeanalvesr.domain.repository.Clientes;
import io.github.jeanalvesr.domain.repository.Pedidos;
import io.github.jeanalvesr.domain.repository.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}