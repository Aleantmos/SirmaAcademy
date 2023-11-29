import java.util.Arrays;
import java.util.Scanner;

public class _1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] dim;

        int[][] m1;
        int[][] m2;

        m1 = extracted(scan);
        m2 = extracted(scan);

        boolean isEqual = true;

        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    if (m1[i][j] != m2[i][j]) {
                        isEqual = false;
                        break;
                    }
                }
                if (!isEqual) {
                    break;
                }
            }
        } else {
            isEqual = false;
        }

        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }


    }

    private static int[][] extracted(Scanner scan) {
        int[][] matrix;
        int[] dim;
        dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

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
