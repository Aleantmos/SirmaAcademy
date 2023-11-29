import java.util.Scanner;

public class _33_TreePattern {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        int end = n - 1;
        for (int i = 1; i <= end; i++) {
            System.out.print(" ");
            if (i == end) {
                System.out.print("*");
            }
        }
    }
}
