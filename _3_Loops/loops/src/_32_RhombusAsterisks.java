import java.util.Scanner;

public class _32_RhombusAsterisks {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int rows = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
