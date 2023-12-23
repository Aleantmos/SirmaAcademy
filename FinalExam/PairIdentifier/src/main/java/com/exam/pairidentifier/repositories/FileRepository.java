package com.exam.pairidentifier.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository {

    private final JdbcTemplate jdbcTemplate;

    public FileRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer checkFilenameCountWith(String originalFilename) {
        String sql = "select count(f.name) from files as f where name = (?)";
        return jdbcTemplate.queryForObject(sql, Integer.class, originalFilename);
    }

    public void saveInDB(String filename) {
        String sql = "insert into files (name) values (?)";
        jdbcTemplate.update(sql, filename);
    }

    public Long getFileIdByName(String originalFilename) {
        String sql = "select f.id from files as f where f.name = (?)";
        return jdbcTemplate.queryForObject(sql, Long.class, originalFilename);
    }
}
