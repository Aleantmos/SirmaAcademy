package com.exam.pairidentifier.services;

import com.exam.pairidentifier.exceptions.InputFormatException;
import com.exam.pairidentifier.exceptions.NullableElementException;
import com.exam.pairidentifier.io.CustomReader;
import com.exam.pairidentifier.io.impl.csv.CSVReader;
import com.exam.pairidentifier.io.impl.csv.CSVWriter;
import com.exam.pairidentifier.repositories.FileRepository;
import com.exam.pairidentifier.repositories.MappingRepository;
import com.exam.pairidentifier.util.MyConstants;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.util.Date;

import static com.exam.pairidentifier.util.MyConstants.ROUGH_FILE_CONTAINER_PATH;
import static com.exam.pairidentifier.util.MyMessages.FILE_SAVED_SUCCESSFULLY_MESSAGE;
import static com.exam.pairidentifier.util.MyMessages.NULLABLE_ELEMENT_EXCEPTION_MESSAGE;


@Service
public class FileService {

    private final MappingRepository mappingRepository;
    private final FileRepository fileRepository;
    private final EmployeeService employeeService;
    private final ProjectService projectService;
    private final DateFormatService dateFormatService;

    @Autowired
    public FileService(MappingRepository mappingRepository,
                       FileRepository fileRepository, EmployeeService employeeService,
                       ProjectService projectService,
                       DateFormatService dateFormatService) {
        this.mappingRepository = mappingRepository;
        this.fileRepository = fileRepository;
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.dateFormatService = dateFormatService;
    }

    @Transactional
    public ResponseEntity<String> saveRoughFile(MultipartFile fileToSave) {
        CSVWriter csvWriter = new CSVWriter();
        csvWriter.write(fileToSave);
        fileRepository.saveInDB(fileToSave.getOriginalFilename());
        return processNewData(fileToSave.getOriginalFilename());
    }

    public ResponseEntity<String> processNewData(String originalFilename) {
        try {
            Long fileId = fileRepository.getFileIdByName(originalFilename);
            String returnMessage = saveObjects(fileId, originalFilename);
            return ResponseEntity.ok(returnMessage);
        } catch (NullableElementException | InputFormatException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Transactional
    private String saveObjects(Long fileId, String originalFilename) throws NullableElementException, InputFormatException {
        List<? extends Serializable> lines = getRoughFileData(originalFilename);

        Set<Long> employeesIds = employeeService.getAllEmployeesIds();
        Set<Long> projectsIds = projectService.getAllProjectIds();

        for (Serializable line : lines) {
            String[] tokens = line.toString().split(",");
            if (!checkNullableTokens(tokens)) {

                //exception caught in upper method
                Long employeeId = Long.parseLong(tokens[0]);
                //exception caught in upper method
                Long projectId = Long.parseLong(tokens[1]);

                //exception caught in upper method
                Date startDate = dateFormatService.parseDate(tokens[2]);
                Date endDate = null;

                if (tokens[3] != null) {
                    endDate = dateFormatService.parseDate(tokens[3]);
                }

                if (!employeesIds.contains(employeeId)) {
                    employeeService.saveNewEmployeeId(employeeId);
                    employeesIds.add(employeeId);
                }

                if (!projectsIds.contains(projectId)) {
                    projectService.saveProject(projectId);
                    projectsIds.add(projectId);
                }
                mappingRepository.insertIntoMappingTable(employeeId, projectId, fileId, startDate, endDate);
            } else {
                throw new NullableElementException(NULLABLE_ELEMENT_EXCEPTION_MESSAGE);
            }
        }
        return FILE_SAVED_SUCCESSFULLY_MESSAGE;
    }

    private boolean checkNullableTokens(String[] tokens) {
        for (int i = 0; i < tokens.length - 2; i++) {
            if (tokens[i] == null) {
                return true;
            }
        }
        return false;
    }

    private static List<? extends Serializable> getRoughFileData(String originalFilename) {
        CustomReader customReader = new CSVReader();
        return customReader.read(ROUGH_FILE_CONTAINER_PATH + originalFilename);
    }

    public Integer getFilenameEntryCount(String originalFilename) {
        return fileRepository.checkFilenameCountWith(originalFilename);
    }

    public Long getFileIdByFilename(String filename) {
        return fileRepository.getFileIdByName(filename);
    }
}
