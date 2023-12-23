package com.exam.pairidentifier.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MappingRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MappingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertIntoMappingTable(Long employeeId, Long projectId, Long fileId, Date startDate, Date endDate){
        String sql = "INSERT INTO employee_project (employee_id, project_id, file_id, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employeeId, projectId, fileId, startDate, endDate);

    }

}
