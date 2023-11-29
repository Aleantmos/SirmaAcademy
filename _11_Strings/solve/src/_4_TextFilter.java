import java.util.Scanner;

public class _4_TextFilter {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String[] elements = scan.nextLine().split(", ");

        StringBuilder sentence = new StringBuilder();

        String input = scan.nextLine();
        while (!input.isEmpty()) {
            sentence.append(input);
            input = scan.nextLine();
        }
        System.out.println(sentence);
    }
}
