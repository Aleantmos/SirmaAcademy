package com.exam.pairidentifier.model.dto;

import java.util.Date;

public class EmployeeDTO {

    private Long id;
    private Long projectId;
    private String startDate;
    private String endDate;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, Long projectId, String startDate, String endDate) {
        this.id = id;
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
