import java.util.Arrays;
import java.util.Scanner;

public class _20_LongestIdenticalSeq {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] nums = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int longestSeq = -1;
        String longestElement = null;
        int index = -1;

        int currCnt = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] ) {
                currCnt++;
                if (longestSeq <= currCnt) {
                    index = i;
                    longestSeq = currCnt;
                    longestElement = String.valueOf(nums[i - 1]);
                }
            } else {
                currCnt = 1;
            }
        }

        System.out.println(index);
        while (longestSeq-- > 0) {
            System.out.print(longestElement + " ");
        }

    }
}
