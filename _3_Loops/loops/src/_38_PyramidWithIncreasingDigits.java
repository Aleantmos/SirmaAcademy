import java.util.Scanner;

public class _38_PyramidWithIncreasingDigits {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                System.out.printf(" ");
            }


            for (int k = i; k < i * 2 + 1; k++) {
                System.out.printf("%d", k + 1);
            }

            for (int m = i * 2; m >= 1 + i; m--) {
                System.out.printf("%d", m);
            }
            System.out.println();
        }
    }
}
