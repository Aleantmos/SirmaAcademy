import java.util.Scanner;

public class _3_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] m1 = new char[rows][cols];
        char[][] m2 = new char[rows][cols];

        m1 = readMatrix(rows, cols, scan);
        m2 = readMatrix(rows, cols, scan);

        char[][] result = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (m1[row][col] != m2[row][col]) {
                    result[row][col] = '*';
                } else {
                    result[row][col] = m1[row][col];
                }
            }
        }

        printResult(result);
    }

    private static void printResult(char[][] result) {

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int rows, int cols, Scanner scan) {

        char[][] matrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split(" ");
            matrix[row] = new char[cols];
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }

        return matrix;
    }
}
