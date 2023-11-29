import java.util.Scanner;

public class _9_SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = Util.importScanner();

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += 2 * i;
        }
        System.out.println(sum);
    }
}
