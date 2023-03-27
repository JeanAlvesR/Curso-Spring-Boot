package io.github.jeanalvesr.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 200)
    private String descricao;

    @Column(name = "preco_unitario",precision = 2)
    private BigDecimal preco;


}
