import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _12_CountCharsInString {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        char[] chars = scan.nextLine().toCharArray();

        Map<Character, Integer> charCnt = new TreeMap<>();

        for (char curr : chars) {
            if (curr != ' ') {
                charCnt.putIfAbsent(curr, 0);
                charCnt.put(curr, charCnt.get(curr) + 1);
            }
        }

        charCnt.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(e -> System.out.printf("%c -> %d%n", e.getKey(), e.getValue()));


    }
}
