import java.util.Arrays;
import java.util.Scanner;

public class _5_SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] nums = Arrays.stream(scan.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(Arrays.stream(nums)
                .filter(num -> num % 2 == 0)
                .sum());
    }
}
