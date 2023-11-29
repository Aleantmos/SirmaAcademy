import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _4_Phonebook {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String input = scan.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phonebook.put(name, number);
            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("stop")) {

            String searchedName = input;

            String number = phonebook.get(searchedName);

            if (number == null) {
                System.out.printf("Contact %s not found.%n", searchedName);
            } else {
                System.out.printf("%s -> %s%n", searchedName, number);
            }

            input = scan.nextLine();
        }

    }
}

