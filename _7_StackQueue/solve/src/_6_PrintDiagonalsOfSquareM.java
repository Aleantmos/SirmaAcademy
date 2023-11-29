import java.util.Arrays;
import java.util.Scanner;

public class _6_PrintDiagonalsOfSquareM {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] left = new int[n];
        int[] right = new int[n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col) {
                    left[row] = matrix[row][col];
                }
                if (n - 1 - col == row) {
                    right[row] = matrix[row][col];
                }
            }
        }

        Arrays.stream(left).forEach(e -> {
            String format = String.format("%d ", e);
            System.out.print(format);
        });
        System.out.println();
        for (int i = 0; i < right.length / 2; i++) {
            int temp = right[i];
            right[i] = right[right.length - 1 - i];
            right[right.length - 1 - i] = temp;
        }
        Arrays.stream(right).forEach(e -> {
            String format = String.format("%d ", e);
            System.out.print(format);
        });
    }
}
