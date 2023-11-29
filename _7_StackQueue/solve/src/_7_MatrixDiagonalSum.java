import java.util.Arrays;
import java.util.Scanner;

public class _7_MatrixDiagonalSum {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[dim[0]][dim[1]];

        int sum = 0;

        for (int row = 0; row < dim[0]; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < dim[1]; col++) {
                if (row == col ) {
                    sum += matrix[row][col];
                }
                if (dim[1] - 1 - col == row) {
                    sum += matrix[row][col];
                }
            }
        }

        System.out.println(sum);
    }
}
