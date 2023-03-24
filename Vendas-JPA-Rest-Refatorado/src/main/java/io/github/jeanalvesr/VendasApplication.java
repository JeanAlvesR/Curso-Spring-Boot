package io.github.jeanalvesr;

import io.github.jeanalvesr.domain.entity.Produto;
import io.github.jeanalvesr.domain.repository.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {


//    @Bean
//    public CommandLineRunner commandLineRunner(@Autowired Produtos produtos){
//        return args -> {
//            Produto produto = new Produto();
//            produto.
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}