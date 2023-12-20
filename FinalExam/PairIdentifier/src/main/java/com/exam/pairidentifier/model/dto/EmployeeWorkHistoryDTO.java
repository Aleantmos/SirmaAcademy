package com.exam.pairidentifier.model.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployeeWorkHistoryDTO implements RowMapper<EmployeeWorkHistoryDTO> {
    private Long employeeId;
    //ProjectId - EmpWorkPeriod
    private Map<Long, List<DateRangeDTO>> historyInProject;

    public EmployeeWorkHistoryDTO(Long employeeId) {
        this.employeeId = employeeId;
        this.historyInProject = new HashMap<>();
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Map<Long, List<DateRangeDTO>> getEmployeesWorkHistory() {
        return historyInProject;
    }

    public void setHistoryInProject(Map<Long, List<DateRangeDTO>> historyInProject) {
        this.historyInProject = historyInProject;
    }

    @Override
    public EmployeeWorkHistoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        //set employee
        EmployeeWorkHistoryDTO employee = new EmployeeWorkHistoryDTO(rs.getLong("employee_id"));

        //set current project
        Long projectId = rs.getLong("project_id");
        employee.getEmployeesWorkHistory().putIfAbsent(projectId, new ArrayList<>());

        //set work history
        Date startDate = rs.getDate("start_date");
        Date endDate = rs.getDate("end_date");
        DateRangeDTO dateRange = new DateRangeDTO(startDate, endDate);
        employee.getEmployeesWorkHistory().get(projectId).add(dateRange);

        return employee;
    }
}
