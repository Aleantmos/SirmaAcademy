import java.util.*;

public class _15_CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String input = scan.nextLine();

        Map<String, List<String>> company = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");

            String companyName = tokens[0];
            String id = tokens[1];

            company.putIfAbsent(companyName, new ArrayList<>());
            List<String> users = company.get(companyName);

            if (!users.contains(id)) {
                users.add(id);
            }
            input = scan.nextLine();
        }

        for (Map.Entry<String, List<String>> set : company.entrySet()) {
            System.out.println(set.getKey());

            StringBuilder sb = new StringBuilder();
            for (String e : set.getValue()) {
                sb.append("-- ")
                        .append(e)
                        .append(System.lineSeparator());
            }

            System.out.print(sb);
        }
    }
}
