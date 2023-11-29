import java.util.Arrays;
import java.util.Scanner;

public class _16_ProcessOddNumbers {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] nums = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int arrCnt;

        if (nums.length % 2 == 0) {
            arrCnt = nums.length / 2;
        } else {
            arrCnt = nums.length / 2 + 1;
        }

        int[] result = new int[arrCnt];

        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                result[cnt++] = nums[i] * 2;
            }
        }

        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i] + " ");
        }
    }
}
