package com.exam.pairidentifier.controller;

import com.exam.pairidentifier.exceptions.UniquenessException;
import com.exam.pairidentifier.services.DateFormatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.exam.pairidentifier.util.MyMessages.*;

@RestController
@RequestMapping("/formats")
public class DateFormatController {

    private final DateFormatService dateFormatService;

    public DateFormatController(DateFormatService dateFormatService) {
        this.dateFormatService = dateFormatService;
    }

    @PostMapping("/add-new-format")
    public ResponseEntity<String> addNewFormat(@RequestParam("format") String format) {
        try {
            dateFormatService.saveFormat(format);
            return ResponseEntity.ok(FORMAT_ADDED_MESSAGE);
        } catch (UniquenessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(FORMAT_ALREADY_EXISTS_MESSAGE);
        }
    }

    @DeleteMapping("/delete-format")
    public ResponseEntity<String> deleteFormat(@RequestParam("format") String format) {
        Boolean deletedSuccessful = dateFormatService.deleteFormat(format);

        if (deletedSuccessful) {
            return ResponseEntity.ok(FORMAT_DELETED_MESSAGE);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FORMAT_NOT_PRESENT_MESSAGE);
    }
}
