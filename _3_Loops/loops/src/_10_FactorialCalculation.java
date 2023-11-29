import java.util.Scanner;

public class _10_FactorialCalculation {
    public static void main(String[] args) {
        Scanner scanner = Util.importScanner();

        int num = Integer.parseInt(scanner.nextLine());

        int fact = 1;

        for (int i = 1; i <= num; i++) {
            fact *= i;
        }

        System.out.println(fact);
    }
}
