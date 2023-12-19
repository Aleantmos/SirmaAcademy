package com.exam.pairidentifier.services;

import com.exam.pairidentifier.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Long employeeId) {
        //todo extra => check from existing employees from prior .csv imports
        employeeRepository.save(employeeId);
    }
}
