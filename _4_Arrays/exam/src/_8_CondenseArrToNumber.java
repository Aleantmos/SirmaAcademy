import java.util.Arrays;
import java.util.Scanner;

public class _8_CondenseArrToNumber {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] arr = Arrays.stream(scan.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (arr.length > 1) {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i] + arr[i + 1];
            }
            arr = newArr;
        }

        System.out.println(arr[0]);
    }
}
