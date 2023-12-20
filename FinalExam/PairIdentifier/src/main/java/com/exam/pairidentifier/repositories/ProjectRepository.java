package com.exam.pairidentifier.repositories;

import com.exam.pairidentifier.model.dto.EmployeeProjectPeriodDTO;
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

    public List<EmployeeProjectPeriodDTO> getAllProjectsWithEmployees() {
        String sql = "select ep.project_id, ep.employee_id, ep.start_date, ep_end_date from employee_project as ep order by ep.employee_id";
        return jdbcTemplate.queryForList(sql, EmployeeProjectPeriodDTO.class);
    }

    public List<Long> getAllIds() {
        String sql = "select p.id from projects as p";
        return jdbcTemplate.queryForList(sql, Long.class);
    }
}
