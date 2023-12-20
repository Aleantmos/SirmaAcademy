package com.exam.pairidentifier.controller;

import com.exam.pairidentifier.model.dto.PairInfoDTO;
import com.exam.pairidentifier.services.EmployeeService;
import com.exam.pairidentifier.services.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public String receiveFile() {
//        if (file.isEmpty()) {
//            return "The file you sent is empty.";
//        }

        //fileService.saveRoughFile(file);

        fileService.processData();
        return "OK";
    }

    @GetMapping("/longest-colab")
    public String getLongestCollaboration() {
        List <PairInfoDTO> pairs = employeeService.findMostCollaborativePair();

        Optional<PairInfoDTO> first = pairs.stream()
                .sorted(Comparator.comparing(PairInfoDTO::getTotalDaysCommon)
                        .reversed())
                .findFirst();

        System.out.println(first.get().getEmployeeIdOne() + " " + first.get().getEmployeeIdTwo());
        System.out.println(first.get().getTotalDaysCommon());
        return "banana";
    }

}
