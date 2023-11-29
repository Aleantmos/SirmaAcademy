import java.util.Scanner;

public class _9_WordFilter {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String[] elements = scan.nextLine().split(" ");

        for (String element : elements) {
            if (element.length() % 2 == 0) {
                System.out.println(element);
            }
        }
    }
}
