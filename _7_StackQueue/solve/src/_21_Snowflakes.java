import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _21_Snowflakes {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];

        String[][] matrix = new String[rows][cols];

        List<int[]> flakePointContainer = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split(" ");

            for (int col = 0; col < cols; col++) {
                String curr = line[col];
                matrix[row][col] = curr;

                if (curr.equals("*")) {
                    flakePointContainer.add(new int[]{row, col});
                }
            }
        }

        boolean canFall = true;

        while (canFall) {
            canFall = false;
            for (int[] ints : flakePointContainer) {
                int currRow = ints[0];
                int currCol = ints[1];

                if (currRow != rows - 1 && !matrix[currRow + 1][currCol].equals("#")) {
                    matrix[currRow][currCol] = "0";
                    matrix[currRow + 1][currCol] = "*";
                    canFall = true;
                }
                ints[0] = currRow + 1;

            }
            printMatrix(matrix);
            printBorder(rows);
        }
    }

    private static void printBorder(int rows) {
        for (int cnt = 0; cnt < rows; cnt++) {
            System.out.print("=");
        }
        System.out.println();
    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
