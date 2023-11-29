import java.util.Scanner;

public class _35_ChristmasTree {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");

            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }

            System.out.print(" | ");

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }


            for (int k = 0; k < n - i - 1; k++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
