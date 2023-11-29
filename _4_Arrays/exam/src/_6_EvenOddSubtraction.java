import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class _6_EvenOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] nums = Arrays.stream(scan.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();


        int result = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                result += num;
            } else {
                result -= num;
            }
        }

        System.out.println(result);
    }
}
