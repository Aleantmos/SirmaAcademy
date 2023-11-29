import java.util.Scanner;

public class _41_HourGlassPattern {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int num = Integer.parseInt(scan.nextLine());
        int n;
        int rightSide;

        int index;

        if (num % 2 == 0) {
            n = num + 1;
            rightSide = n;
        } else {
            n = num + 2;
            rightSide = n - 1;
        }

        for (int row = 0; row < n; row++) {
            if (row == 0 || row == n - 1) {
                for (int j = 0; j < num + 2; j++) {
                    System.out.print("#");
                }
                System.out.println();
            } else {
                if (row > (num / 2) && num % 2 == 0) {
                    index = row + 1;
                } else {
                    index = row;
                }
                for (int j = 0; j <= n; j++) {
                    if (j == index || j == rightSide - index) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
