import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _17_MagicSquareChecker {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] dim = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];


        int[] sumRows = new int[rows];
        int[] sumCols = new int[cols];
        int[] diagonals = new int[2];

        if (rows != cols) {
            System.out.println("False");
        } else {

            for (int row = 0; row < rows; row++) {
                String[] line = scan.nextLine().split(" ");
                for (int col = 0; col < cols; col++) {
                    int element = Integer.parseInt(line[col]);
                    sumRows[row] += element;
                    sumCols[col] += element;

                    if (row == col) {
                        diagonals[0] += element;
                    }
                    if (cols - 1 - col == row) {
                        diagonals[1] += element;
                    }
                }
            }
        }

        int globalSum = sumRows[0];

        List<int[]> arrList = List.of(sumRows, sumCols, diagonals);


        for (int[] ints : arrList) {
            for (int anInt : ints) {
                if (anInt != globalSum) {
                    System.out.println("False");
                    break;
                }
            }
        }

        System.out.println("True");

    }
}
