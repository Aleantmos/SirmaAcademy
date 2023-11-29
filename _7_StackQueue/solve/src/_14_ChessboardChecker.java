import java.util.Arrays;
import java.util.Scanner;

public class _14_ChessboardChecker {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];

        int[][] matrix = new int[rows][];


        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        boolean isThreatened = isQueenThreatened(rows, cols, matrix);

        if (isThreatened) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }



    }

    private static boolean isQueenThreatened(int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 1) {
                    for (int i = row; i < rows; i++) {
                        for (int j = col + 1; j < cols; j++) {
                            if (matrix[i][j] == 1 && canThreaten(row, col, i, j)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean canThreaten(int x1, int y1, int x2, int y2) {

        if (x1 == x2 || y1 == y2) {
            return true;
        }

        if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            return true;
        }

        return false;
    }
}
