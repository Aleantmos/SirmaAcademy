package com.exam.pairidentifier.services;

import com.exam.pairidentifier.exceptions.InputFormatException;
import com.exam.pairidentifier.model.dto.DateRangeDTO;
import com.exam.pairidentifier.model.dto.EmployeeDTO;
import com.exam.pairidentifier.model.dto.EmployeeWorkHistoryDTO;
import com.exam.pairidentifier.model.dto.PairInfoDTO;
import com.exam.pairidentifier.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private List<PairInfoDTO> pairs;
    private final EmployeeRepository employeeRepository;
    private final ProjectService projectService;
    private final DateFormatService dateFormatService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ProjectService projectService, DateFormatService dateFormatService) {
        this.employeeRepository = employeeRepository;
        this.projectService = projectService;
        this.dateFormatService = dateFormatService;
    }

    public void saveNewEmployeeId(Long employeeId) {
        employeeRepository.save(employeeId);
    }

    public List<PairInfoDTO> findMostCollaborativePairFromAll() {
        pairs = new ArrayList<>();
        List<Long> allEmployeeIds = employeeRepository.getAllEmployeeIds();

        Map<Long, EmployeeWorkHistoryDTO> allEmployeeWorkRecords = new HashMap<>();

        return findPairLogic(allEmployeeIds, allEmployeeWorkRecords, pairs);
    }

    public List<PairInfoDTO> findMostCollaborativePairFromFile(Long fileId) {
        pairs = new ArrayList<>();

        List<Long> allEmployeesIdsFromFile = employeeRepository.getAllEmployeesFromFile(fileId);

        Map<Long, EmployeeWorkHistoryDTO> allEmployeeWorkRecords = new HashMap<>();

        return findPairLogic(allEmployeesIdsFromFile, allEmployeeWorkRecords, pairs);
    }


    public Set<Long> getAllEmployeesIds() {
        List<Long> allEmployeeIds = employeeRepository.getAllEmployeeIds();
        return new HashSet<>(allEmployeeIds);
    }

    private List<PairInfoDTO> findPairLogic(List<Long> allEmployeeIds, Map<Long, EmployeeWorkHistoryDTO> allEmployeeWorkRecords, List<PairInfoDTO> pairs) {
        for (Long employeeId : allEmployeeIds) {

            EmployeeWorkHistoryDTO workRecord = new EmployeeWorkHistoryDTO(employeeId);
            Map<Long, List<DateRangeDTO>> employeeWorkHistory = employeeRepository.getEmployeeWorkHistory(employeeId);
            workRecord.setHistoryInProject(employeeWorkHistory);
            allEmployeeWorkRecords.put(employeeId, workRecord);
        }


        for (int e1 = 0; e1 < allEmployeeIds.size() - 1; e1++) {
            Long e1Id = allEmployeeIds.get(e1);
            EmployeeWorkHistoryDTO e1WorkHistory = allEmployeeWorkRecords.get(e1Id);

            for (Long possibleCommonProject : e1WorkHistory.getEmployeesWorkHistory().keySet()) {

                for (int e2 = e1 + 1; e2 < allEmployeeIds.size(); e2++) {
                    Long e2Id = allEmployeeIds.get(e2);
                    Map<Long, List<DateRangeDTO>> e2WorkHistory = allEmployeeWorkRecords.get(e2Id).getEmployeesWorkHistory();
                    List<DateRangeDTO> e2WorkHistoryInProject = e2WorkHistory.get(possibleCommonProject);

                    if (e2WorkHistoryInProject != null) {
                        List<DateRangeDTO> e1WorkHistoryInProject = allEmployeeWorkRecords.get(e1Id).getEmployeesWorkHistory().get(possibleCommonProject);

                        e1WorkHistoryInProject.stream()
                                .sorted(Comparator.comparing(DateRangeDTO::getStartDate))
                                .collect(Collectors.toList());

                        checkOverlap(e1WorkHistoryInProject, e2WorkHistoryInProject, e1Id, e2Id, possibleCommonProject);

                    }
                }
            }
        }
        return pairs;
    }

    private void checkOverlap(List<DateRangeDTO> e1WorkHistoryInProject,
                              List<DateRangeDTO> e2WorkHistoryInProject,
                              Long e1Id,
                              Long e2Id,
                              Long e1ProjectId) {
        for (DateRangeDTO e1CurrRange : e1WorkHistoryInProject) {
            for (DateRangeDTO e2CurrRange : e2WorkHistoryInProject) {
                Date s1 = e1CurrRange.getStartDate();
                Date e1 = e1CurrRange.getEndDate();

                Date s2 = e2CurrRange.getStartDate();
                Date e2 = e2CurrRange.getEndDate();

                PairInfoDTO pairInfoDTO = pairs.stream()
                        .filter(p -> p.getEmployeeIdOne().equals(e1Id) && p.getEmployeeIdTwo().equals(e2Id))
                        .findFirst()
                        .orElse(new PairInfoDTO(e1Id, e2Id));

                Date latestStart = getLatestStart(s1, s2);

                Date earliestEnd = getEarliestEnd(e1, e2);

                if (!latestStart.after(earliestEnd)) {
                    long diffInMillis = earliestEnd.getTime() - latestStart.getTime();

                    //I always lose the first day when subtracting
                    long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS) + 1;

                    pairInfoDTO.addAmount(diffInDays);
                    pairInfoDTO.getCommonProjects().put(e1ProjectId, diffInDays);

                    pairs.add(pairInfoDTO);
                }
            }
        }
    }

    private static Date getEarliestEnd(Date e1, Date e2) {
        Date earliestEnd;
        if (e1.before(e2)) {
            earliestEnd = e1;
        } else {
            earliestEnd = e2;
        }
        return earliestEnd;
    }

    private static Date getLatestStart(Date s1, Date s2) {
        Date latestStart;
        if (s1.after(s2)) {
            latestStart = s1;
        } else {
            latestStart = s2;
        }
        return latestStart;
    }

    public void saveNewEmployee(EmployeeDTO employeeDTO) throws InputFormatException {
        if (checkIfProjectExists(employeeDTO.getProjectId())) {
            projectService.saveProject(employeeDTO.getProjectId());
        }

        if (checkIfEmployeeExists(employeeDTO.getId())) {
            employeeRepository.save(employeeDTO.getId());
        }

        Date startDate = checkDate(employeeDTO.getStartDate());
        Date endDate = checkDate(employeeDTO.getEndDate());
        employeeRepository.saveSingleEmployee(
                employeeDTO.getId(),
                employeeDTO.getProjectId(),
                startDate,
                endDate);
    }

    private Date checkDate(String startDate) throws InputFormatException {
        return dateFormatService.parseDate(startDate);
    }

    private boolean checkIfEmployeeExists(Long id) {
        Long count = employeeRepository.getEmployeeCountWith(id);
        return count == 0;
    }

    private boolean checkIfProjectExists(Long projectId) {
        Long count = projectService.getProjectCountWith(projectId);
        return count == 0;
    }

    public EmployeeWorkHistoryDTO getEmployeeWordHistoryWithId(Long id) {
        if (checkIfEmployeeExists(id)) {
            throw new NoSuchElementException("Employee with this id does not exist.");
        }

        Map<Long, List<DateRangeDTO>> employeeWorkHistory = employeeRepository.getEmployeeWorkHistory(id);

        EmployeeWorkHistoryDTO employeeWorkHistoryDTO = new EmployeeWorkHistoryDTO(id);
        employeeWorkHistoryDTO.setHistoryInProject(employeeWorkHistory);

        return employeeWorkHistoryDTO;
    }

    public String deleteEmployee(Long id) {
        if (checkIfEmployeeExists(id)) {
            throw new NoSuchElementException("Employee with this id does not exist.");
        }
        int affected = employeeRepository.deleteEmployee(id);

        if (affected == 1) {
            return "Deletion successful";
        }

        throw new IllegalStateException("Something went wrong. Please try again.");
    }
}