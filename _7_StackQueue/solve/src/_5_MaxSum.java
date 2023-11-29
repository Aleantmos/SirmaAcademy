import java.util.Arrays;
import java.util.Scanner;

public class _5_MaxSum {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = readMatrix(dim, scan);

        int bestSum = Integer.MIN_VALUE;
        int bestPoint[] = new int[2];

        for (int row = 0; row < matrix.length - 1; row++) {
            int currSum = 0;
            for (int col = 0; col < matrix[row].length - 1; col++) {
                currSum += matrix[row][col];
                currSum += matrix[row][col + 1];
                currSum += matrix[row + 1][col];
                currSum += matrix[row + 1][col + 1];

                if (currSum > bestSum) {
                    bestSum = currSum;
                    bestPoint[0] = row;
                    bestPoint[1] = col;
                }
                currSum = 0;
            }
        }

        System.out.println(bestSum);

        System.out.printf("%d %d%n%d %d", matrix[bestPoint[0]][bestPoint[1]],
                matrix[bestPoint[0]][bestPoint[1] + 1],
                matrix[bestPoint[0] + 1][bestPoint[1]],
                matrix[bestPoint[0] + 1][bestPoint[1] + 1]);
    }

    public static int[][] readMatrix(int[] dim, Scanner scan) {
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

