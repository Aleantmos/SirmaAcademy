import java.util.Arrays;
import java.util.Scanner;

public class _7_EqualArr {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] arr1 = Arrays.stream(scan.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] arr2 = Arrays.stream(scan.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minLength = Integer.min(arr1.length, arr2.length);

        int diff = -1;
        int sum = 0;



        for (int i = 0; i < minLength; i++) {
            if (arr1[i] == arr2[i]) {
                sum += arr1[i];
            } else {
                diff = i;
                break;
            }
        }

        if (diff != -1) {
            System.out.printf("Arrays are not identical. Found difference at %d index.%n", diff);
        } else {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }

    }
}
