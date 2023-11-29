import java.util.Scanner;

public class _8_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String[] input = scan.nextLine().split(" ");

        int dim = Integer.parseInt(input[0]);

        String command = input[1];
        int[][] matrix = new int[0][];
        if (command.equals("A")) {
             matrix = patternA(dim);
        } else if (command.equals("B")) {
            matrix = patternB(dim);
        }

        printMatrix(matrix);
    }

    private static int[][] patternB(int dim) {

        int cnt = 1;
        int row = 0;

        int[][] matrix = new int[dim][dim];

        for (int col = 0; col < dim; col++) {
            for (int i = 0; i < dim; i++) {
                if (col % 2 == 1) {
                    matrix[--row][col] = cnt++;
                } else {
                    matrix[row++][col] = cnt++;
                }
            }
        }
        return matrix;
    }

    private static int[][] patternA(int dim) {

        int cnt = 1;

        int[][] matrix = new int[dim][dim];
        for (int col = 0; col < dim; col++) {
            for (int row = 0; row < dim; row++) {
                matrix[row][col] = cnt++;
            }
        }
        return matrix;
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
