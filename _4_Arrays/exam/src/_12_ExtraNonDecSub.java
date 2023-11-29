import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _12_ExtraNonDecSub {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] nums = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int curr = nums[0];

        int[] arr = new int[]{curr};

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= curr) {
                int[] newArr = new int[arr.length + 1];
                for (int j = 0; j < arr.length; j++) {
                    newArr[j] = arr[j];
                }
                newArr[newArr.length - 1] = nums[i];
                curr = nums[i];
                arr = newArr;
            }
        }

        String result = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
