import java.util.Arrays;
import java.util.Scanner;

public class _10_ZeroMatrix {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];

        boolean[][] visited = new boolean[rows][cols];
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == 0 && !visited[row][col]) {
                    setZeros(matrix, row, col, rows, cols, visited);
                } else {
                    visited[row][col] = true;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] matrix, int rowIndex, int colIndex, int rows, int cols, boolean[][] visited) {

        for (int row = 0; row < rows; row++) {
            if (matrix[row][colIndex] != 0) {
                matrix[row][colIndex] = 0;
                visited[row][colIndex] = true;
            }
        }

        for (int col = 0; col < cols; col++) {
            if (matrix[rowIndex][col] != 0) {
                matrix[rowIndex][col] = 0;
                visited[rowIndex][col] = true;
            }
        }
    }
}
