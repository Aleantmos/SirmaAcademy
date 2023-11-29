import java.util.Scanner;

public class _26_EvenPairs {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n1 = Integer.parseInt(scan.nextLine());
        int m1 = Integer.parseInt(scan.nextLine());

        int diff1 = Integer.parseInt(scan.nextLine());
        int n2 = diff1 + n1;

        int diff2 = Integer.parseInt(scan.nextLine());
        int m2 = diff2 + m1;

        for (int i = n1; i <= n2; i++) {
            for (int j = m1; j <= m2; j++) {
                if (isPrime(i) && isPrime(j)) {
                    System.out.printf("%d%d%n", i, j);
                }
            }
        }
    }

    static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
