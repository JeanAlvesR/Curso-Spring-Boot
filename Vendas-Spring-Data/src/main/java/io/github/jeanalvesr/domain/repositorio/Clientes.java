package io.github.jeanalvesr.domain.repositorio;

import io.github.jeanalvesr.domain.entity.Cliente;
import org.h2.result.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static String INSERT = "INSERT INTO CLIENTE (NOME) VALUES (?) ";
    private static String UPDATE = "UPDATE CLIENTE SET NOME =? WHERE ID = ?";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";
    private static String DELETE = "DELETE FROM CLIENTE WHERE ID = ?";

    @Autowired //Já vem configurado com base no properties para se conectar ao banco.
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public Cliente atualizar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }

    public List<Cliente> buscarPorNome(String nome) {
        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like  '%"+nome+"%'") , obterClienteMapper());
    }

    public void deletar(Cliente cliente) {
        jdbcTemplate.update(DELETE, new Object[]{cliente.getId()});
    }

    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    private RowMapper<Cliente> obterClienteMapper() {

        return (rs, rowNum)->{return new Cliente(rs.getInt("id"), rs.getString("nome"));};
//        new RowMapper<Cliente>() {
//            @Override
//            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return new Cliente(rs.getInt("id"), rs.getString("nome"));
//            };
//
//        };
    }
}
