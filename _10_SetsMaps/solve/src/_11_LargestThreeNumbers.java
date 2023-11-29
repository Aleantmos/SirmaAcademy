import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _11_LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String[] arrNums = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());

        List<Integer> nums = Arrays.stream(arrNums)
                .map(Integer::parseInt)
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(n)
                .toList();

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer num : nums) {
            stringBuilder.append(num).append(" ");
        }

        System.out.println(stringBuilder.toString().trim());



    }
}
