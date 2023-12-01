package com.exam.cmbasic.repository;

import com.exam.cmbasic.models.Client;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class ClientRepo implements BaseRepo {

    private JdbcTemplate jdbcTemplate;

    public ClientRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addClient(Client client) {
        String sql = "insert into clients(name, email) values (?, ?)";

        jdbcTemplate.update(sql, client.getName(), client.getEmail());


    }

    @Override
    public boolean editClient(int id, Client client) {
        String sql = "update clients set name = (?), email = (?) where id = (?)";
        int rowsAffected = jdbcTemplate.update(sql, client.getName(), client.getEmail(), id);

        return rowsAffected == 2;
    }

    @Override
    public Client getClient(int id) throws Exception {
        String sql = "select c.id, c.name, c.email from clients as c where c.id = ?";

        Client client = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Client.class));

        if (client == null) {
            throw new Exception("No user with this id");
        }

        return client;
    }

    @Override
    public List<Client> getAllClients() {
        String sql = "select * from clients";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    @Override
    public void removeClient(int id) {
        String sql = "delete from clients where client = (?)";
        jdbcTemplate.update(sql, id);
    }
}
