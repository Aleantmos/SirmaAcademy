package com.exam.pairidentifier.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Long projectId) {
        jdbcTemplate.update("INSERT INTO projects (id) VALUES (?)", projectId);
    }


    public List<Long> getAllIds() {
        String sql = "select p.id from projects as p";
        return jdbcTemplate.queryForList(sql, Long.class);
    }
}
