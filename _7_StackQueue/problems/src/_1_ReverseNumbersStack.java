import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _1_ReverseNumbersStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nums = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> reversed = new ArrayDeque<>();

        for (int num : nums) {
            reversed.push(num);
        }
        StringBuilder result = new StringBuilder();

        while (!reversed.isEmpty()) {
            result.append(reversed.pop()).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
