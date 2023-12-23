package com.exam.pairidentifier.controller;

import com.exam.pairidentifier.services.FileService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.exam.pairidentifier.util.MyMessages.FILE_EMPTY_MESSAGE;


@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload-csv")
    @Transactional
    public ResponseEntity<String> receiveFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(FILE_EMPTY_MESSAGE);
        }

        //todo -> check for more exceptions
        if (!filenameUnique(file.getOriginalFilename())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("A file with this name already exists");
        }

        return fileService.saveRoughFile(file);
    }

    private boolean filenameUnique(String originalFilename) {
        Integer count = fileService.getFilenameEntryCount(originalFilename);
        return count == 0;
    }
}
