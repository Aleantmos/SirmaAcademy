package com.exam.pairidentifier.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DateFormatRepository {
    private final JdbcTemplate jdbcTemplate;

    public DateFormatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getSupportedFormats() {
        String sql = "select format from date_formats";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public long getFormatsCount() {
        String sql = "select count(*) from date_formats";

        //todo May produce NullPointer
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    public void save(String format) {
        String sql = "insert into date_formats (format) values (?)";
        jdbcTemplate.update(sql, format);
    }

    public List<String> getFormat() {
        String sql = "select format from date_formats";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public int deleteFormat(String format) {
        String sql = "delete from date_formats where format = (?) ";
        return jdbcTemplate.update(sql, format);
    }
}
