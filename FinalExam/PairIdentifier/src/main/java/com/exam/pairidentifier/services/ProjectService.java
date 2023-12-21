package com.exam.pairidentifier.services;

import com.exam.pairidentifier.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Set<Long> getAllProjectIds() {
        List<Long> allIds = projectRepository.getAllIds();
        return new HashSet<>(allIds);
    }

//    public List<EmployeeProjectPeriodDTO> getAllProjectsEmployeesWorkHistoryOrderedByEmpIdInAsc() {
//        return projectRepository.getAllProjectsWithEmployees();
//    }


}
