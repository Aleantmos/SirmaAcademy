import java.util.Arrays;
import java.util.Scanner;

public class _1_SumFirstAndLastArr {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] arr = Arrays.stream(scan.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = arr[0] + arr[arr.length - 1];

        System.out.println(sum);
    }
}
