import java.util.*;
import java.util.stream.Collectors;

public class _8_OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        Map<String, Integer> occurrences = new LinkedHashMap<>();

        String[] input = scan.nextLine().split(" ");

        for (String token : input) {
            String curr = token.toLowerCase();
            occurrences.putIfAbsent(curr, 0);
            occurrences.put(curr, occurrences.get(curr) + 1);
        }

        List<String> result = occurrences.keySet()
                .stream()
                .filter(v -> occurrences.get(v) % 2 == 1)
                .toList();

        System.out.println(String.join(", ", result));

    }
}
