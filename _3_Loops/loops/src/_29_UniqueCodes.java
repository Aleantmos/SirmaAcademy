import java.util.Scanner;

public class _29_UniqueCodes {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int d1 = Integer.parseInt(scan.nextLine());
        int d2 = Integer.parseInt(scan.nextLine());
        int d3 = Integer.parseInt(scan.nextLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= d1; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= d2; j++) {
                    if (isPrime(j)) {
                        for (int k = 1; k <= d3; k++) {
                            if (k % 2 == 0) {
                                sb.append(String.format("%d %d %d", i, j, k))
                                        .append(System.lineSeparator());
                            }
                        }
                    }
                }
            }
        }
        System.out.print(sb.toString().trim());
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

