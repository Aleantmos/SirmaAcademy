import dbOps.CustomReader;
import dbOps.CustomWriter;
import dbOps.csv.CSVReader;
import dbOps.csv.CSVWriter;
import model.entity.managers.Manager;
import service.Service;
import utils.Util;
import model.entity.managers.StaffManager;
import model.enums.CommandEnum;
import service.StaffService;


public class StaffManagementApp {
    public static void main(String[] args) {


        CustomReader reader = new CSVReader();
        CustomWriter writer = new CSVWriter();

        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);

        System.out.println("Welcome to Staff Management System");
        displayCommands();

        boolean isRunning = true;

        while (isRunning) {
            String command = Util.scan().nextLine().toUpperCase();
            //checks if command exist
            checkCommandValidity(command);

            manager.execute(command);
            displayCommands();

            if (command.equals("EXIT")) {
                isRunning = false;
            }
        }
    }

    private static void checkCommandValidity(String command) {
        while (!commandExists(command)) {
            System.out.println("Please type a valid command\n");
            displayCommands();
            command = Util.scan().nextLine().toUpperCase();
        }
    }

    private static boolean commandExists(String command) {
        for (CommandEnum value : CommandEnum.values()) {
            if (value.toString().equals(command)) {
                return true;
            }
        }
        return false;
    }

    private static void displayCommands() {
        System.out.println("""
                1)Add Employee -> type Add
                2)Edit Employee -> type Edit
                3)Fire Employee -> type Fire
                4)List Employees -> type List
                5)Search Employees -> type Search
                6)Exit App -> type Exit""");
    }
}
