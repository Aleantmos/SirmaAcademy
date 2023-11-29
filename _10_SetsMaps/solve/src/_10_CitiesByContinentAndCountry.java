import java.util.*;

public class _10_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        Map<String, Map<String, List<String>>> continentsInfo = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(" ");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continentsInfo.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> currContinent = continentsInfo.get(continent);

            currContinent.putIfAbsent(country, new ArrayList<>());
            currContinent.get(country).add(city);

        }

        for (String continent : continentsInfo.keySet()) {
            StringBuilder builder = new StringBuilder();

            Map<String, List<String>> currContinent = continentsInfo.get(continent);

            builder.append(String.format("%s:%n",continent));

            for (String country : currContinent.keySet()) {
                builder.append(" ").append(country)
                        .append(" -> ");

                List<String> cities = currContinent.get(country);
                builder.append(String.join(", ", cities))
                        .append(System.lineSeparator());
            }

            System.out.print(builder);
        }

    }


}
