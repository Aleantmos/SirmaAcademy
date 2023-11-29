import java.util.Scanner;

public class TODO_37_HousePattern {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        int size = (n - 1) / 2;

        for (int i = 0; i <= size + 2; i++) {
            //if (2 * i + 1 <= n) {
            if (i <= size) {
                for (int j = 0; j < size - i; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print("*");

                }
                System.out.println();
            } else {
                for (int j = 0; j < size + 2; j++) {
                    if (j == 0 || j == size + 2 - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
