import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _13_ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int n = Integer.parseInt(scan.nextLine());

        Map<String, String> registry = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(" ");

            String command = tokens[0];

            if (command.equals("Register")) {
                String user = tokens[1];
                if (registry.containsKey(user)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", registry.get(user));
                } else {
                    String licencePlate = tokens[2];
                    registry.put(user, licencePlate);

                    System.out.printf("%s registered %s successfully.%n", user, licencePlate);
                }

            } else if (command.equals("Unregister")){
                String name = tokens[1];
                String removed = registry.remove(name);

                if (removed == null) {
                    System.out.printf("ERROR: user %s not found.%n", name);
                } else {
                    System.out.printf("%s unregistered successfully.%n", name);
                }
            }
        }
        for (Map.Entry<String, String> set : registry.entrySet()) {
            System.out.printf("%s => %s%n", set.getKey(), set.getValue());
        }
    }
}
