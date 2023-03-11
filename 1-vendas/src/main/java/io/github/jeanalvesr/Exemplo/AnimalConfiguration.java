package io.github.jeanalvesr.Exemplo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfiguration {
    @Bean(name = "cachorro")
    public Animal cachorro(){
        return () -> System.out.println("Au Au");
    }

    @Bean(name = "gato")
    public Animal gato(){
        return () -> System.out.println("Miau");
    }
}
