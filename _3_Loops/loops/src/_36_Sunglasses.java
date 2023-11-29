import java.util.Scanner;

public class _36_Sunglasses {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());
        int middle = 0;

        if (n % 2 == 0) {
            middle = n / 2 - 1;
        } else {
            middle = n / 2;
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n * 2; j++) {
                if (i == 0 || i == n - 1) {
                    System.out.print("*");
                } else if (j == 0 || j == n * 2 - 1) {
                    System.out.print("*");
                } else {
                    System.out.print("/");
                }
            }

            for (int j = 0; j < n; j++) {
                if (i == middle) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }


            for (int j = 0; j < n * 2; j++) {
                if (i == 0 || i == n - 1) {
                    System.out.print("*");
                } else if (j == 0 || j == n * 2 - 1) {
                    System.out.print("*");
                } else {
                    System.out.print("/");
                }
            }

            System.out.println();
        }
    }
}
