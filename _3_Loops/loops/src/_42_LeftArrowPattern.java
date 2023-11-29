import java.util.Scanner;

public class _42_LeftArrowPattern {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        int upperEnd = n - 1;
        int upperInnerEnd = n - 1;
        for (int i = 1; i <= upperEnd; i++) {
            for (int j = 0; j < upperInnerEnd; j++) {
                if (j >= upperEnd - i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        int lowerEnd = n - 2;
        int lowerInnedEnd = n - 1;
        for (int i = 1; i <= lowerEnd; i++) {
            for (int j = 0; j < lowerInnedEnd; j++) {
                if (j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            if (i != lowerEnd) {
                System.out.println();
            }
        }
    }
}
