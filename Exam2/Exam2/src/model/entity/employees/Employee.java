package model.entity.employees;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable, Fireable {

    private Long id;
    private String name;
    private LocalDate startDate;
    private String department;
    private String role;
    private Double salary;

    private boolean isFired;

    public Employee(Long id, String name, String department, String role, Double salary) {
        this.id = id;
        this.name = name;
        this.startDate = LocalDate.now();
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.isFired = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean isFired() {
        return isFired;
    }

    @Override
    public void fire() {
        this.isFired = true;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%.2f",
                getId(),
                getName(),
                getStartDate().toString(),
                getDepartment(),
                getRole(),
                getSalary());
    }
}
