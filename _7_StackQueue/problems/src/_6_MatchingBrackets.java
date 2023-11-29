import java.util.ArrayDeque;
import java.util.Scanner;

public class _6_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        ArrayDeque<Integer> indexContainer = new ArrayDeque<>();

        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '(') {
                indexContainer.push(i);
            } else if (curr == ')') {
                Integer from = indexContainer.pop();
                System.out.println(input.substring(from, i + 1));
            }
        }


    }
}
