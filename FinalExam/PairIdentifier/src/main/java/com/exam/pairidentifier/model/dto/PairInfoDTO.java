package com.exam.pairidentifier.model.dto;

import java.util.ArrayList;
import java.util.List;

public class PairInfoDTO {
    private Long employeeIdOne;
    private Long employeeIdTwo;
    private Long totalDaysCommon = 0l;
    private List<Long> commonProjects;

    public PairInfoDTO(Long employeeIdOne, Long employeeIdTwo) {
        this.employeeIdOne = employeeIdOne;
        this.employeeIdTwo = employeeIdTwo;
        //this.totalDaysCommon = 0L;
        this.commonProjects = new ArrayList<>();
    }

    public Long getEmployeeIdOne() {
        return employeeIdOne;
    }

    public void setEmployeeIdOne(Long employeeIdOne) {
        this.employeeIdOne = employeeIdOne;
    }

    public Long getEmployeeIdTwo() {
        return employeeIdTwo;
    }

    public void setEmployeeIdTwo(Long employeeIdTwo) {
        this.employeeIdTwo = employeeIdTwo;
    }

    public Long getTotalDaysCommon() {
        return totalDaysCommon;
    }

    public void addAmount(Long totalDaysCommon) {
        this.totalDaysCommon += totalDaysCommon;
    }

    public List<Long> getCommonProjects() {
        return commonProjects;
    }

    public void setCommonProjects(List<Long> commonProjects) {
        this.commonProjects = commonProjects;
    }
}
