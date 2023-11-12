package dbOps.csv;

import dbOps.CustomReader;
import model.entity.employees.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements CustomReader {

    @Override
    public List<? extends Serializable> read(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                //checking for any spaces
                if (!line.isBlank()) {
                    //parse to Employee and add to List
                    String[] values = line.split(",");
                    Employee employee = new Employee(
                            Long.parseLong(values[0]),
                            values[1],
                            values[3],
                            values[4],
                            Double.parseDouble(values[5]));

                    employee.setStartDate(getDateFormat(values[2]));
                    employees.add(employee);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private LocalDate getDateFormat(String value) {
        String[] split = value.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        return LocalDate.of(year, month, day);
    }
}
