package com.exam.pairidentifier.controller;

import com.exam.pairidentifier.model.dto.PairInfoDTO;
import com.exam.pairidentifier.services.EmployeeService;
import com.exam.pairidentifier.services.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;
    private final EmployeeService employeeService;

    public FileController(FileService fileService, EmployeeService employeeService) {
        this.fileService = fileService;
        this.employeeService = employeeService;
    }

    @PostMapping("/upload-csv")
    public ResponseEntity<String> receiveFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The file you sent is empty.");
        }

        //todo -> check for more exceptions
        fileService.saveRoughFile(file);

        //todo -> check for more exceptions
        fileService.processNewData();

        return ResponseEntity.ok().body("File uploaded successfully.");
    }



}
