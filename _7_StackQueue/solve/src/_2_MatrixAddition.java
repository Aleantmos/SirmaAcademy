import java.util.Arrays;
import java.util.Scanner;

public class _2_MatrixAddition {
    public static void main(String[] args) {
        Scanner scan = Util.scan();
        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] m1 = readMatrix(scan, dim);
        int[][] m2 = readMatrix(scan, dim);

        int[][] result = new int[dim[0]][dim[1]];

        for (int i = 0; i < dim[0]; i++) {
            for (int j = 0; j < dim[1]; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }


    private static int[][] readMatrix(Scanner scan, int[] dim) {
        int[][] matrix;

        matrix = new int[dim[0]][dim[1]];

        for (int i = 0; i < dim[0]; i++) {
            int[] line = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < dim[1]; j++) {
                matrix[i][j] = line[j];
            }
        }

        return matrix;
    }
}
