package com.exam.pairidentifier.services;

import com.exam.pairidentifier.io.CustomReader;
import com.exam.pairidentifier.io.impl.CSVReader;
import com.exam.pairidentifier.repositories.MappingRepository;
import com.exam.pairidentifier.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Date;
import java.util.*;

@Service
public class FileService {

    private final MappingRepository mappingRepository;
    private final EmployeeService employeeService;
    private final ProjectService projectService;


    @Autowired
    public FileService(MappingRepository mappingRepository, EmployeeService employeeService, ProjectService projectService) {
        this.mappingRepository = mappingRepository;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    public void processData() {
        saveObjects();
    }

    private void saveObjects() {
        List<? extends Serializable> lines = getRoughFileData();

        Set<Long> employeesIds = new HashSet<>();
        Set<Long> projectsIds = new HashSet<>();


        for (Serializable line : lines) {
            String[] tokens = line.toString().split(",");

            Long employeeId = Long.parseLong(tokens[0]);
            Long projectId = Long.parseLong(tokens[1]);
            Date startDate = getDate(tokens[2]);
            Date endDate = null;

            if (tokens[3] != null) {
                endDate = getDate(tokens[3]);
            }

            if (!employeesIds.contains(employeeId)) {
                employeeService.saveEmployee(employeeId);
                employeesIds.add(employeeId);
            }

            if (!projectsIds.contains(projectId)) {
                projectService.saveProject(projectId);
                projectsIds.add(projectId);
            }

            mappingRepository.insertIntoMappingTable(employeeId, projectId, startDate, endDate);
        }



    }

    private static List<? extends Serializable> getRoughFileData() {
        CustomReader customReader = new CSVReader();
        return customReader.read(MyConstants.ROUGH_FILE_PATH);
    }

    private Date getDate(String token) {
        //todo implement all date formats
        return Date.valueOf(token);
    }


    public void saveRoughFile(MultipartFile file) {
       //todo -> save rough file
    }
}
