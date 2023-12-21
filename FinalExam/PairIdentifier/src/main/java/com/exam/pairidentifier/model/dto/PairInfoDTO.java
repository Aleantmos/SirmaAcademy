package com.exam.pairidentifier.model.dto;

import java.util.HashMap;
import java.util.List;

public class PairInfoDTO {
    private Long employeeIdOne;
    private Long employeeIdTwo;
    private Long totalDaysCommon = 0l;
    private HashMap<Long, Long> commonProjects;

    public PairInfoDTO(Long employeeIdOne, Long employeeIdTwo) {
        this.employeeIdOne = employeeIdOne;
        this.employeeIdTwo = employeeIdTwo;
        //this.totalDaysCommon = 0L;
        this.commonProjects = new HashMap<>();
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

    public HashMap<Long, Long> getCommonProjects() {
        return commonProjects;
    }

    public void setCommonProjects(HashMap<Long, Long> commonProjects) {
        this.commonProjects = commonProjects;
    }
}
