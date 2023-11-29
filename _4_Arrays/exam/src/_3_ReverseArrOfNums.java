import java.util.Arrays;
import java.util.Scanner;

public class _3_ReverseArrOfNums {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int n = Integer.parseInt(scan.nextLine());

        int[] arr = Arrays.stream(scan.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] subArr = new int[n];

        for (int i = 0; i < n; i++) {
            subArr[i] = arr[i];
        }
        

        for (int i = 0; i < subArr.length / 2; i++) {
            int temp = subArr[i];
            subArr[i] = subArr[subArr.length - 1 - i];
            subArr[subArr.length - i - 1] = temp;
        }

        Arrays.stream(subArr).forEach(s -> System.out.print(s + " "));
    }
}
