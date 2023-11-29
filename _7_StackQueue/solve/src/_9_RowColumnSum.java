import java.util.Arrays;
import java.util.Scanner;

public class _9_RowColumnSum {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];

        int[] rowSum = new int[dim[0]];
        int[] colSum = new int[dim[1]];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rowSum[row] += matrix[row][col];
                colSum[col] += matrix[row][col];
            }
        }

        StringBuilder sumRow = getSum(rowSum);
        System.out.println("Row Sums: " + sumRow);

        StringBuilder sumCol = getSum(colSum);
        System.out.println("Column Sums: " + sumCol);

    }

    private static StringBuilder getSum(int[] sum) {


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sum.length; i++) {
            if (i == sum.length - 1) {
                sb.append(sum[i]);

            } else {
                sb.append(sum[i])
                        .append(", ");
            }
        }

        return sb;
    }
}
