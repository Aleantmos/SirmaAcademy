package com.exam.pairidentifier.services;

import com.exam.pairidentifier.model.dto.DateRangeDTO;
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

    private final List<PairInfoDTO> pairs = new ArrayList<>();
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Long employeeId) {
        //todo extra => check from existing employees from prior .csv imports
        employeeRepository.save(employeeId);
    }

    public List<PairInfoDTO> findMostCollaborativePair() {
        if (pairs.isEmpty()) {
            List<Long> allEmployeeIds = employeeRepository.getAllEmployeeIds();

            Map<Long, EmployeeWorkHistoryDTO> allEmployeeWorkRecords = new HashMap<>();

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


                Date latestStart;
                if (s1.after(s2)) {
                    latestStart = s1;
                } else {
                    latestStart = s2;
                }

                Date earliestEnd;
                if (e1.before(e2)) {
                    earliestEnd = e1;
                } else {
                    earliestEnd = e2;
                }

                if (!latestStart.after(earliestEnd)) {
                    long diffInMillis = earliestEnd.getTime() - latestStart.getTime();
                    long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);


                    pairInfoDTO.addAmount(diffInDays);
                    pairInfoDTO.getCommonProjects().add(e1ProjectId);

                    pairs.add(pairInfoDTO);
                }
            }
        }
    }
    private Date getEarliestEnd(Date s1, Date s2) {
        int result = s1.compareTo(s2);

        if (result > 0) {
            return s1;
        } else {
            return s2;
        }
    }

    private Date getLaterDate(Date e1, Date e2) {
        int result = e1.compareTo(e2);

        if (result < 0) {
            return e2;
        } else {
            return e1;
        }
    }

}