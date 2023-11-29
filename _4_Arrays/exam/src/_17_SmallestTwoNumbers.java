import java.util.Arrays;
import java.util.Scanner;

public class _17_SmallestTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] nums = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = new int[2];

        int smallest = Integer.MAX_VALUE;
        int smallestIndex = -1;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (smallest > nums[j]) {
                    smallestIndex = j;
                    smallest = nums[j];
                }
            }
            result[i] = nums[smallestIndex];
            nums[smallestIndex] = Integer.MAX_VALUE;
            smallest = Integer.MAX_VALUE;
        }

        if (result[0] < result[1]) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println(result[1] + " " + result[0]);
        }
    }
}
