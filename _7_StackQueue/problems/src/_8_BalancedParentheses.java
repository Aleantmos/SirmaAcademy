import java.util.ArrayDeque;
import java.util.Scanner;

public class _8_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String[] input = scan.nextLine().split("");

        boolean isFalse = false;
        ArrayDeque<String> parentheses = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String curr = input[i];
            if (curr.equals("[") || curr.equals("{") || curr.equals("(")) {
                parentheses.push(curr);
            } else {
                String opening = parentheses.pop();

                if (opening.equals("(") && !curr.equals(")") ||
                    opening.equals("{") && !curr.equals("}") ||
                    opening.equals("[") && !curr.equals("]"))  {

                    isFalse = true;
                }
            }
            if (isFalse) {
                break;
            }
        }
        System.out.println(!isFalse);
    }
}
