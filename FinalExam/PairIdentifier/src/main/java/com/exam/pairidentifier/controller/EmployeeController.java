package com.exam.pairidentifier.controller;

import com.exam.pairidentifier.model.dto.PairInfoDTO;
import com.exam.pairidentifier.model.dto.response.ApiError;
import com.exam.pairidentifier.model.dto.response.ApiResponse;
import com.exam.pairidentifier.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/longest-collab")
    public ResponseEntity<ApiResponse> getLongestCollaboration() {
        List<PairInfoDTO> pairs = employeeService.findMostCollaborativePair();

        Optional<PairInfoDTO> first = pairs.stream()
                .sorted(Comparator.comparing(PairInfoDTO::getTotalDaysCommon)
                        .reversed())
                .findFirst();

        ApiResponse apiResponse = new ApiResponse();

        if (first.isPresent()) {
            PairInfoDTO bestPair = first.get();

            apiResponse.setBestPair(bestPair);

            return ResponseEntity.ok(apiResponse);
        } else {
            ApiError apiError = new ApiError("No pairs were found");

            apiResponse.setError(apiError);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
}
