import java.util.Scanner;

public class _3_Substring {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String element = scan.nextLine();

        String input = scan.nextLine();

        while (input.contains(element)) {
            input = input.replace(element, "");
        }

        System.out.println(input);
    }
}
