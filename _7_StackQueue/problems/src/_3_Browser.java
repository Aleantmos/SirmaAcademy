import java.util.ArrayDeque;
import java.util.Scanner;

public class _3_Browser {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String input = scan.nextLine();

        ArrayDeque<String> deque = new ArrayDeque<>();

        while (!input.equals("Home")) {
            String result = "";

            if (!input.equals("back")) {
                deque.push(input);
                result = input;
            } else if (deque.size() >= 2) {
                deque.pop();
                result = deque.peek();

            } else {
                result = "no previous URLs";
            }
            System.out.println(result);
            input = scan.nextLine();

        }
    }
}
