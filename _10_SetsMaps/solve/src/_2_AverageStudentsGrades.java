import java.util.*;

public class _2_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> averageContainer = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(" ");

            String name = tokens[0];
            Double currGrade = Double.parseDouble(tokens[1]);

            averageContainer.putIfAbsent(name, new ArrayList<>());
            averageContainer.get(name).add(currGrade);
        }

        for (String key : averageContainer.keySet()) {
            double currAverage = averageContainer.get(key).stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);

            StringBuilder builder = new StringBuilder();
            for (Double element : averageContainer.get(key)) {
                builder.append(String.format("%.2f", element)).append(" ");
            }

            System.out.printf("%s -> %s (avg: %.2f)%n", key, builder.toString().trim(), currAverage);
        }
    }
}
