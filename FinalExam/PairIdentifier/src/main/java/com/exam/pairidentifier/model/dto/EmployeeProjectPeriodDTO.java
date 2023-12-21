//package com.exam.pairidentifier.model.dto;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import java.time.Instant;
//import java.util.Date;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class EmployeeProjectPeriodDTO implements RowMapper<EmployeeProjectPeriodDTO> {
//    private Long projectId;
//    private Long employeeId;
//    private DateRangeDTO dateRangeDTO;
//
//    public EmployeeProjectPeriodDTO() {
//    }
//
//    public Long getProjectId() {
//        return projectId;
//    }
//
//    public void setProjectId(Long projectId) {
//        this.projectId = projectId;
//    }
//
//    public Long getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(Long employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public DateRangeDTO getDateRangeDTO() {
//        return dateRangeDTO;
//    }
//
//    public void setDateRangeDTO(DateRangeDTO dateRangeDTO) {
//        this.dateRangeDTO = dateRangeDTO;
//    }
//
//    @Override
//    public EmployeeProjectPeriodDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//        EmployeeProjectPeriodDTO currObject = new EmployeeProjectPeriodDTO();
//        currObject.setEmployeeId(rs.getLong("employee_id"));
//        currObject.setProjectId(rs.getLong("project_id"));
//
//        DateRangeDTO currDateRange = new DateRangeDTO();
//        Date startDate = rs.getDate("start_date");
//        Date endDate = rs.getDate("end_date");
//        if (endDate == null) {
//            endDate = Date.from(Instant.now());
//        }
//
//        currDateRange.setStartDate(startDate);
//        currDateRange.setEndDate(endDate);
//
//        currObject.setDateRangeDTO(currDateRange);
//        return currObject;
//    }
//}
