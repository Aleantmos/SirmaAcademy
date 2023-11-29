import java.util.Scanner;

public class _1_ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String input = scan.nextLine();
        while (!input.equals("end")) {
            StringBuilder reversed = new StringBuilder();
            for (int i = input.length() - 1; i >= 0; i--) {
                reversed.append(input.charAt(i));
            }

            System.out.printf("%s = %s%n", input, reversed);

            input = scan.nextLine();
        }
    }
}
