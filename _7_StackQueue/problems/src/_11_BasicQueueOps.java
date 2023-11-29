import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _11_BasicQueueOps {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] input = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int enqueueCnt = input[0];
        int dequeueCnt = input[1];
        int elementPresent = input[2];

        int[] nums = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int size = enqueueCnt + dequeueCnt;

        for (int i = 0; i < size; i++) {
            if (i < enqueueCnt) {
                queue.offer(nums[i]);
            } else {
                queue.poll();
            }
        }
        System.out.println(
                queue.contains(elementPresent) ?
                true :
                queue.stream().min(Comparator.comparing(Integer::intValue))
                        .orElse(0)
        );


    }
}
