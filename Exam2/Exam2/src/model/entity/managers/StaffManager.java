package model.entity.managers;

import model.enums.CommandEnum;
import service.Service;

public class StaffManager extends Manager {


    public StaffManager(Service service) {
        super(service);
    }

    @Override
    public void execute(String command) {
        CommandEnum commandEnum = CommandEnum.valueOf(command);
        switch (commandEnum) {
            case ADD:
                service.addEmployee();
                break;
            case EDIT:
                service.editEmployee();
                break;
            case FIRE:
                service.fireEmployee();
                break;
            case LIST:
                service.listEmployees();
                break;
            case SEARCH:
                service.searchBy();
                break;
            case EXIT:
                service.exit();
                break;
        }
    }
}

    /*public void execute(String command) {
        CommandEnum commandEnum = CommandEnum.valueOf(command);
        switch (commandEnum) {
            case ADD:
                service.addEmployee();
                break;
            case EDIT:
                service.editEmployee();
                break;
            case FIRE:
                service.fireEmployee();
                break;
            case LIST:
                service.listEmployees();
                break;
            case SEARCH:
                service.searchBy();
                break;
            case EXIT:
                service.exit();
                break;
        }
    }*/


