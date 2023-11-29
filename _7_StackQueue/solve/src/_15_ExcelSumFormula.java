import java.util.Arrays;
import java.util.Scanner;

public class _15_ExcelSumFormula {
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

        String[] range = scan.nextLine().split(":");

        String[] fromPoint = range[0].split("");
        String[] toPoint = range[1].split("");


        int[] from = readPoint(fromPoint);
        int[] to = readPoint(toPoint);

        int sum = 0;

        for (int row = from[0]; row <= to[0]; row++) {
            for (int col = from[1]; col <= to[1]; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(sum);
    }

    private static int[] readPoint(String[] data) {
        int[] point = new int[2];

        int col = data[0].charAt(0) - 65;
        int row = Integer.parseInt(data[1]) - 1;

        point[0] = row;
        point[1] = col;
        return point;
    }
}
