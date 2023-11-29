import java.util.Arrays;
import java.util.Scanner;

public class _11_MatrixBoundarySum {
    public static void main(String[] args) {
        Scanner scan = Util.scan();


        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int boundarySum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 || col == 0 || row == rows - 1 || col == cols - 1) {
                    boundarySum += matrix[row][col];
                }
            }
        }

        System.out.println(boundarySum);
    }
}
