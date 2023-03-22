package io.github.jeanalvesr.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
//@Table(name = "tb_cliente", schema = "vendas" ) -> Utilizar quando a tabela persistida tiver o nome diferente da entidade. Caso não esteja no default, dá para especificar o schema.
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //Anotation para representar que é auto_increment
    @Column(name = "id") //quando o atributo tem o nome diferente na coluna, nesse caso não tem, porém não interefere deixar.
    private Integer id;
    @Column(name= "nome", length = 100)
    private String nome; //Quando utiliza @Entity, já é sub-entendido que os seus atributos são colunas.

    @Column(name = "cpf",length = 11)
    private String cpf;

    @JsonIgnore //Quando uma requisição get vir, ele não retorna os pedidos
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY ) //usa o nome que está dentro da classe Pedido
    private Set <Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
