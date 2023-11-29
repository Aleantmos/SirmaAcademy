import java.util.Scanner;

public class _2_RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String[] elements = scan.nextLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < elements.length; i++) {
            String curr = elements[i];

            for (int j = 0; j < curr.length(); j++) {
                result.append(curr);
            }
        }

        System.out.println(result);
    }
}
