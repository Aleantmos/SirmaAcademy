import java.util.Arrays;
import java.util.Scanner;

public class _18_SpiralMatrix {
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

        int top = 0;
        int bottom = matrix.length;

        int left = 0;
        int right = matrix[0].length;



        while (top != bottom && left != right) {

            printUpper(matrix, left, right, top);
            top++;

            printRight(matrix, top, bottom, right);
            right--;

            printBottom(matrix, right, left, bottom);
            bottom--;

            printLeft(matrix, bottom, top, left);
            left++;
        }

    }

    private static void printLeft(int[][] matrix, int bottom, int top, int left) {
        for (int i = bottom - 1; i >= top; i--) {
            System.out.print(matrix[i][left] + " ");
        }
    }

    private static void printBottom(int[][] matrix, int right, int left, int bottom) {
        for (int i = right - 1; i >= left; i--) {
            System.out.print(matrix[bottom - 1][i] + " ");
        }
    }

    private static void printRight(int[][] matrix, int top, int bottom, int right) {
        for (int i = top; i < bottom; i++) {
            System.out.print(matrix[i][right - 1] + " ");
        }
    }

    private static void printUpper(int[][] matrix, int left, int right, int top) {
        for (int i = left; i < right; i++) {
            System.out.print(matrix[top][i] + " ");
        }
    }
}
