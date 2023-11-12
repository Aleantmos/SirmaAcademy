package dbOps;

import model.entity.employees.Employee;

import java.util.Collection;

public interface CustomWriter {
    void write (Collection<Employee> items, String filename);

}
