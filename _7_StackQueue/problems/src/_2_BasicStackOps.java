import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class _2_BasicStackOps {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int[] data = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int toPushCnt = data[0];
        int toPopCnt = data[1];
        int elementToFind = data[2];

        int[] arr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int size = toPushCnt + toPopCnt;

        for (int i = 0; i < size; i++) {
            if (i < toPushCnt) {
                deque.push(arr[i]);
            } else {
                deque.pop();
            }
        }

        if (deque.contains(elementToFind)) {
            System.out.println(true);
        } else {
            int smallest = deque.stream()
                    .min(Comparator.comparingInt(Integer::intValue))
                    .orElse(0);
            System.out.println(smallest);
        }


    }
}
