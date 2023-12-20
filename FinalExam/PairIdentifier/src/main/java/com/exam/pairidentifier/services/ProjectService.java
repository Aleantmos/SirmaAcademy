package com.exam.pairidentifier.services;

import com.exam.pairidentifier.model.dto.EmployeeProjectPeriodDTO;
import com.exam.pairidentifier.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void saveProject(Long projectId) {
        projectRepository.save(projectId);
    }

//    public List<EmployeeProjectPeriodDTO> getAllProjectsEmployeesWorkHistoryOrderedByEmpIdInAsc() {
//        return projectRepository.getAllProjectsWithEmployees();
//    }

//    public List<Long> getAllProjectIds() {
//        return projectRepository.getAllIds();
//    }
}
