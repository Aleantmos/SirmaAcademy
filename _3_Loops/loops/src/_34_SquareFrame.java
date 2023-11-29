import java.util.Scanner;

public class _34_SquareFrame {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int rows = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < rows; j++) {
                if ((i == 0 || i == rows - 1) && (j == 0 || j == rows - 1)) {
                    System.out.print("+");
                } else if (j > 0 && j <  rows - 1) {
                    System.out.print("-");
                } else if ((i > 0 && (j == 0 || j == rows - 1)) && (i < rows - 1 && (j == 0 || j == rows - 1))) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
