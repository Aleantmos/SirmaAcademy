import java.util.Arrays;
import java.util.Scanner;

public class _13_NegativePositive {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] nums = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cnt = 0;
        int i = 0;

        while (cnt < nums.length) {
            int curr = nums[i];

            if (curr >= 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = curr;
                i--;
            } else {
                int temp = nums[i];
                for (int j = i; j > 0; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[0] = temp;
            }

            cnt++;
            i++;
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
