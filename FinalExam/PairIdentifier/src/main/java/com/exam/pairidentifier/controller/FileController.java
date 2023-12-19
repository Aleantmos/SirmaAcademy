package com.exam.pairidentifier.controller;

import com.exam.pairidentifier.services.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload-csv")
    public String receiveFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "The file you sent is empty.";
        }

        //fileService.saveRoughFile(file);

        fileService.processData();
        return "OK";
    }

}
