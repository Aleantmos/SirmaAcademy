package com.exam.pairidentifier.controller;

import com.exam.pairidentifier.exceptions.InputFormatException;
import com.exam.pairidentifier.model.dto.EmployeeDTO;
import com.exam.pairidentifier.model.dto.EmployeeWorkHistoryDTO;
import com.exam.pairidentifier.model.dto.PairInfoDTO;
import com.exam.pairidentifier.model.dto.response.ApiError;
import com.exam.pairidentifier.model.dto.response.ApiResponse;
import com.exam.pairidentifier.services.EmployeeService;
import com.exam.pairidentifier.services.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.exam.pairidentifier.util.MyMessages.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final FileService fileService;

    public EmployeeController(EmployeeService employeeService, FileService fileService) {
        this.employeeService = employeeService;
        this.fileService = fileService;
    }

    //todo --> what happens when I have two or more best pairs?
    @GetMapping("/longest-collab")
    public ResponseEntity<ApiResponse> getLongestCollaboration() {
        List<PairInfoDTO> pairs = employeeService.findMostCollaborativePairFromAll();

        return getApiPairResponse(pairs);
    }

    @GetMapping("/longest-collab-file")
    public ResponseEntity<ApiResponse> getLongestCollaborationFromFile(@RequestParam(name = "file") String file) {
        Long fileId = fileService.getFileIdByFilename(file);
        List<PairInfoDTO> pairs = employeeService.findMostCollaborativePairFromFile(fileId);

        return getApiPairResponse(pairs);
    }

    private static ResponseEntity<ApiResponse> getApiPairResponse(List<PairInfoDTO> pairs) {
        Optional<PairInfoDTO> first = pairs.stream()
                .sorted(Comparator.comparing(PairInfoDTO::getTotalDaysCommon)
                        .reversed())
                .findFirst();

        ApiResponse apiResponse = new ApiResponse();

        if (first.isPresent()) {
            PairInfoDTO bestPair = first.get();
            apiResponse.setResponse(bestPair);

            return ResponseEntity.ok(apiResponse);
        } else {
            ApiError apiError = new ApiError(NO_COLLABORATIVE_PAIRS_MESSAGE);
            apiResponse.setError(apiError);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            employeeService.saveNewEmployee(employeeDTO);
            return ResponseEntity.ok(String.format(EMPLOYEE_CREATED_MESSAGE, employeeDTO.getId()));
        } catch (InputFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ApiResponse<EmployeeWorkHistoryDTO> getEmployee(@RequestParam Long id) {
        ApiResponse response = new ApiResponse();
        try {
            EmployeeWorkHistoryDTO employeeWorkHistory = employeeService.getEmployeeWordHistoryWithId(id);
            response.setResponse(employeeWorkHistory);
            return response;
        } catch (NoSuchElementException e) {
            ApiError apiError = new ApiError(e.getMessage());
            response.setError(apiError);
            return response;
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {
        try {
            String result = employeeService.deleteEmployee(id);
            return ResponseEntity.ok(result);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}