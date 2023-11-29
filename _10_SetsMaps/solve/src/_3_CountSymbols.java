import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _3_CountSymbols {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        char[] chars = scan.nextLine().toCharArray();

        Map<Character, Integer> charContainer = new TreeMap<>();

        for (char aChar : chars) {
            charContainer.putIfAbsent(aChar, 0);
            charContainer.put(aChar, charContainer.get(aChar) + 1);
        }

        for (Character key : charContainer.keySet()) {
            Integer keyCnt = charContainer.get(key);

            System.out.println(String.format("%s: %d", key, keyCnt));
        }


    }
}
