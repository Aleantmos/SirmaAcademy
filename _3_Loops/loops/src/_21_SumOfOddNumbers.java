import java.util.Scanner;

public class _21_SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int curr = 2 * i + 1;
            System.out.println(curr);
            sum += curr;
        }
        System.out.printf("Sum: %d%n%n", sum);

    }
}
