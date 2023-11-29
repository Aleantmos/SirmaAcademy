import java.util.Scanner;

public class _30_SquareAsterisks {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print("* ");
                }
            }
            if (i != n - 1) {
                System.out.println();
                System.out.println();
            }
        }
    }
}
