import java.util.Arrays;
import java.util.Scanner;

public class _4_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];

        System.out.println(rows);
        System.out.println(cols);

        long sum = 0;
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sum += Arrays.stream(matrix[row]).sum();
        }

        System.out.println(sum);
    }
}
