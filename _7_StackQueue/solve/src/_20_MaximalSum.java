import javax.management.MBeanTrustPermission;
import java.util.Arrays;
import java.util.Scanner;

public class _20_MaximalSum {
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

        int rowStart = 0;
        int colStart = 0;

        int localSum = 0;
        int globalSum = Integer.MIN_VALUE;
        int bestRowIndex = -1;
        int bestColIndex = -1;

        while (rowStart < rows - 2 && colStart < cols - 2) {
            localSum = 0;
            for (int i = rowStart; i < rowStart + 3; i++) {
                for (int j = colStart; j < colStart + 3; j++) {
                    localSum += matrix[i][j];
                }
            }

            if (localSum > globalSum) {
                globalSum = localSum;
                bestRowIndex = rowStart;
                bestColIndex = colStart;
            }

            colStart++;
            if (colStart == cols - 2) {
                colStart = 0;
                rowStart++;
            }
        }

        System.out.println(globalSum);

        for (int i = bestRowIndex; i < bestRowIndex + 3; i++) {
            for (int j = bestColIndex; j < bestColIndex + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
