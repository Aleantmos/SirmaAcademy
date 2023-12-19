package com.exam.pairidentifier.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formats")
public class DateFormatController {

    @PostMapping("/add-new-format")
    public String addNewFormat(@RequestParam("format") String format) {
        //todo add option to add and delete formats
        return "something soon";
    }

    @DeleteMapping("/delete-format")
    public String deleteFormat(@RequestParam("format") String format) {
        //todo
        return "something soon";
    }
}
