package dbOps.csv;

import dbOps.CustomWriter;
import model.entity.employees.Employee;

import java.io.*;
import java.util.Collection;

public class CSVWriter implements CustomWriter {

    @Override
    public void write(Collection<Employee> employees, String filePath) {
        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Serializable employee : employees) {
                writer.println(employee.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}