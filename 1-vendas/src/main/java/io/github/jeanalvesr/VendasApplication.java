package io.github.jeanalvesr;

import io.github.jeanalvesr.Exemplo.Animal;
import io.github.jeanalvesr.Exemplo.Cachorro;
import io.github.jeanalvesr.Exemplo.Gato;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {

    //forma de procurar a propriedade no arquivo application.properties
    @Value("${application.name}")
    private String applicationName;


    @Cachorro
    private Animal animal;

    @Bean(name = "executarAnimal")
    public CommandLineRunner executar(){
        return args -> {
            this.animal.fazerBarulho();
        };
    }

    @Gato
    private Animal animal2;

    @Bean(name = "executarAnimalGato")
    public CommandLineRunner executar2(){
        return args -> {
            this.animal2.fazerBarulho();
        };
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return applicationName;
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}