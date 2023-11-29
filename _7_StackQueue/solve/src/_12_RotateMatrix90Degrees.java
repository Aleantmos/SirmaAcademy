import java.util.Arrays;
import java.util.Scanner;

public class _12_RotateMatrix90Degrees {
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

        int[][] result = new int[cols][rows];


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result[row][cols - 1 - col] = matrix[col][row];
            }
        }

        printMatrix(result);
    }


    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
