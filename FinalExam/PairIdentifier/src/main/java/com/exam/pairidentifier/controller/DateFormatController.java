package com.exam.pairidentifier.controller;

import com.exam.pairidentifier.exceptions.UniquenessException;
import com.exam.pairidentifier.services.DateFormatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formats")
public class DateFormatController {

    private final DateFormatService dateFormatService;

    public DateFormatController(DateFormatService dateFormatService) {
        this.dateFormatService = dateFormatService;
    }

    @PostMapping("/add-new-format")
    public ResponseEntity<String> addNewFormat(@RequestParam("format") String format) {
        //todo add option to add and delete formats
        try {
            dateFormatService.saveFormat(format);
            return ResponseEntity.ok("Format added successfully.");
        } catch (UniquenessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Format already exists.");
        }
    }

    @DeleteMapping("/delete-format")
    public ResponseEntity<String> deleteFormat(@RequestParam("format") String format) {
        Boolean deletedSuccessful = dateFormatService.deleteFormat(format);

        if (deletedSuccessful) {
            return ResponseEntity.ok("Format deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Format was not present at all.");
    }
}
