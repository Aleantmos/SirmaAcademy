package service;

import dbOps.CustomReader;
import dbOps.CustomWriter;
import model.entity.employees.Employee;
import utils.Util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffService implements Service {
    private Map<Long, Employee> employees = new HashMap<>();
    private final CustomReader customReader;
    private final CustomWriter customWriter;


    public StaffService(CustomReader customReader, CustomWriter customWriter) {
        this.customReader = customReader;
        this.customWriter = customWriter;
        this.employees = getEmployeesFromDb();
    }

    @Override
    public void addEmployee() {
        System.out.println("Please submit employee information:");
        String[] info = Util.scan().nextLine().split(", ");

        Employee employee = checkEmployeeAddData(info);

        if (employee != null) {
            employees.put(employee.getId(), employee);
            System.out.println("Employee saved successfully");
        } else {
            System.out.println("Please try again with new data");
        }
    }

    @Override
    public void editEmployee() {
        System.out.println("Please submit employee id:");
        String submittedId = Util.scan().nextLine();

        Employee existingData = findEmployeeById(submittedId);

        if (existingData == null) {
            return;
        }
        System.out.println("Please submit new user data:");

        String[] newData = Util.scan().nextLine().split(", ");
        Employee edited = checkEmployeeEditData(newData);

        if (edited == null) {
            System.out.println("Please try again");
        } else {
            edited.setStartDate(existingData.getStartDate());
            employees.replace(existingData.getId(), edited);
            System.out.println("Edit successful");
        }
    }

    @Override
    public void listEmployees() {
        if (employees.values().isEmpty()) {
            System.out.println("No employees currently");
            return;
        }
        for (Employee employee : employees.values()) {
            if (!employee.isFired()) {
                System.out.println(employee.toString());
            }
        }
    }



    @Override
    public void searchBy() {
        System.out.println("Choose factor to search by (Name, Id or Department):");
        String input = Util.scan().nextLine().toUpperCase();

        switch (input) {
            case "NAME" -> {
                String searchFactor = getSearchedElement();
                Employee byName = findByName(searchFactor);
                checkIfExists(byName);
            }
            case "DEPARTMENT" -> {
                String searchFactor = getSearchedElement();
                Employee byDepartment = findByDepartment(searchFactor);
                checkIfExists(byDepartment);
            }
            case "ID" -> {
                String searchFactor = getSearchedElement();
                Employee employeeById = findEmployeeById(searchFactor);
                checkIfExists(employeeById);
            }
            default -> System.out.println("Please submit correct factor");
        }
    }

    @Override
    public void fireEmployee() {
        System.out.println("Please submit id:");
        String id = Util.scan().nextLine();

        Employee employeeById = findEmployeeById(id);

        if (employeeById != null) {
            checkIfAlreadyFired(employeeById);
        }
    }

    @Override
    public void exit() {
        saveData(employees.values());

    }

    private Double salaryValidity(String salary) {
        Double salaryAsDouble;

        try {
            salaryAsDouble = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            return null;
        }
        return salaryAsDouble;
    }

    private boolean roleValidity(String role) {
        return isBlank(role);
    }

    private boolean departmentValidity(String department) {
        return isBlank(department);
    }

    private boolean nameValidity(String name) {
        return isBlank(name) || name.split(" ").length != 2;
    }

    private boolean idUniqueness(long id) {
        return employees.containsKey(id);
    }

    private static boolean isBlank(String field) {
        return field.isBlank();
    }

    private Map<Long, Employee> getEmployeesFromDb() {
        List<Employee> data = (List<Employee>) customReader.read(Util.employeeFilePath());

        for (Employee employee : data) {
            employees.put(employee.getId(), employee);
        }

        return this.employees;
    }

    private static String getSearchedElement() {
        System.out.println("Please submit searched element:");
        return Util.scan().nextLine();
    }

    private Employee findByDepartment(String department) {
        return employees.values()
                .stream()
                .filter(e -> e.getDepartment().equals(department))
                .findFirst()
                .orElse(null);
    }

    private void checkIfExists(Employee employee) {
        if (employee != null) {
            System.out.println(employee.toString());
        } else {
            System.out.println("Employee does not exist");
        }
    }

    private Employee findByName(String name) {
        return employees.values().stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private void saveData(Collection<Employee> values) {
        customWriter.write(values, Util.employeeFilePath());
        System.out.println("Data saved successfully");
    }

    private Employee checkEmployeeAddData(String[] info) {
        Long id = checkValidNumber(info[0]);
        if (id == null) {
            return null;
        }
        if (idUniqueness(id)) {
            printMessage("Id not unique");
            return null;
        }
        return checkRestOfData(info, id);
    }

    private Employee checkEmployeeEditData(String[] info) {
        Long id = checkValidNumber(info[0]);
        if (id == null) {
            return null;
        }

        return checkRestOfData(info, id);
    }

    private Employee checkRestOfData(String[] info, Long id) {
        String name = info[1];
        if (nameValidity(name)) {
            printMessage("First and last name required");

            return null;
        }

        String department = info[2];
        if (departmentValidity(department)) {
            printMessage("Department cannot be blank");
            return null;
        }

        String role = info[3];
        if (roleValidity(role)) {
            printMessage("Role cannot be blank");
            return null;
        }

        String salary = info[4];
        Double salaryAsDouble = salaryValidity(salary);
        if (salaryAsDouble == null) {
            printMessage("Salary not valid");
            return null;
        }

        return new Employee(id, name, department, role, salaryAsDouble);
    }


    private Employee findEmployeeById(String submittedId) {
        Long checkedId = checkValidNumber(submittedId);
        if (checkedId != null && checkedId > 0) {
            Employee byId = getByIdAfterCheck(checkedId);
            if (byId != null) {
                return byId;
            }
        }
        System.out.println("User does not exist");
        return null;
    }

    private static void checkIfAlreadyFired(Employee employeeById) {
        if (employeeById.isFired()) {
            System.out.println("Already fired");
        } else {
            employeeById.fire();
            System.out.println("Fired successfully");
        }
    }

    private Employee getByIdAfterCheck(Long id) {
        for (Map.Entry<Long, Employee> entry : employees.entrySet()) {
            if (entry.getKey().equals(id)) {
                return entry.getValue();
            }
        }
        return null;
    }

    private Long checkValidNumber(String idToCheck) {
        Long id = null;
        try {
            id = Long.parseLong(idToCheck);
        } catch (NumberFormatException e) {
            System.out.println("Id is not a valid number");
        }
        return id;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }


}
