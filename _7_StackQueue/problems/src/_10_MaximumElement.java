import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _10_MaximumElement {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int commandsCnt = Integer.parseInt(scan.nextLine());

        int[] input;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commandsCnt; i++) {

            input = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int command = input[0];

            if (command == 1) {
                stack.push(input[1]);
            } else if (command == 2) {
                stack.pop();
            } else if (command == 3) {
                stack.stream()
                        .max(Comparator.comparingInt(Integer::intValue))
                        .ifPresent(System.out::println);

            }

        }
    }
}
