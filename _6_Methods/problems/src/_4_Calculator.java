import java.util.Scanner;

import static java.math.BigDecimal.divide;

public class _4_Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());

        if (command.equals("add")) {
            add(n1, n2);
        } else if (command.equals("multiply")) {
            multiply(n1, n2);
        } else if (command.equals("subtract")) {
            subtract(n1, n2);
        } else if (command.equals("divide")) {
            divide(n1, n2);
        }
    }

    private static void divide(int n1, int n2) {
        System.out.println(n1/n2);
    }

    private static void add(int n1, int n2) {
        System.out.println(n1 + n2);
    }

    private static void subtract(int n1, int n2) {
        System.out.println(n1 - n2);
    }

    private static void multiply(int n1, int n2) {
        System.out.println(n1 * n2);
    }
}
