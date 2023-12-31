package com.exam.pairidentifier.repositories;

import com.exam.pairidentifier.model.dto.DateRangeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Long employeeId) {
        jdbcTemplate.update("insert into employees (id) values (?)", employeeId);
    }

    public List<Long> getAllEmployeeIds() {
        String sql = "select e.id from employees as e";
        return jdbcTemplate.queryForList(sql, Long.class);
    }
    public Map<Long, List<DateRangeDTO>> getEmployeeWorkHistory(Long employeeId) {
        String sql = "select ep.project_id, ep.start_date, ep.end_date from employee_project as ep " +
                "where ep.employee_id = (?)";

        return jdbcTemplate.query(sql, getResultSetExtractor(), employeeId);
    }

    private ResultSetExtractor<Map<Long, List<DateRangeDTO>>> getResultSetExtractor() {
        return new ResultSetExtractor<>() {
            final Map<Long, List<DateRangeDTO>> history = new HashMap<>();

            @Override
            public Map<Long, List<DateRangeDTO>> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    Long projectId = rs.getLong("project_id");
                    history.putIfAbsent(projectId, new ArrayList<>());

                    Date startDate = rs.getDate("start_date");
                    Date endDate = rs.getDate("end_date");

                    DateRangeDTO dateRange = new DateRangeDTO(startDate, endDate);

                    history.get(projectId).add(dateRange);
                }
                return history;
            }
        };
    }

    public void getEmployeeWithId(Long id) {
    }

    public List<Long> getAllEmployeesFromFile(Long fileId) {
        String sql = "select ep.employee_id from employee_project  as ep where ep.file_id = (?)";
        return jdbcTemplate.queryForList(sql, Long.class,fileId);
    }

    public void saveSingleEmployee(Long id, Long projectId, Date startDate, Date endDate) {
        String sql = "insert into employee_project (employee_id, project_id, start_date, end_date) " +
                "values(?, ?, ?, ?)";

        jdbcTemplate.update(sql, id, projectId, startDate, endDate);
    }

    public Long getEmployeeCountWith(Long id) {
        String sql = "select count(e.id) from employees as e where e.id = (?)";
        return jdbcTemplate.queryForObject(sql, Long.class, id);
    }

    public int deleteEmployee(Long id) {
        String mappingSqlDeletion = "delete from employee_project WHERE employee_id = (?)";
        jdbcTemplate.update(mappingSqlDeletion, id);

        String employeeSqlDeletion = "DELETE FROM employees WHERE id = (?)";
        int affectedInEmployeeTable = jdbcTemplate.update(employeeSqlDeletion, id);

        return affectedInEmployeeTable;
    }
}
