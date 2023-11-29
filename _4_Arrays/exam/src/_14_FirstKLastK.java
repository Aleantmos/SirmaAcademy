import java.util.Arrays;
import java.util.Scanner;

public class _14_FirstKLastK {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int k = Integer.parseInt(scan.nextLine());

        int[] nums = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cnt = 2;


        while (cnt-- > 0) {
            int elements = k;
            if (cnt == 1) {
                for (int i = 0; i < elements; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println();
            } else {
                for (int i = 0; i < elements; i++) {
                    System.out.print(nums[nums.length - elements + i] + " ");
                }
                System.out.println();
            }
        }

    }
}
