import java.util.Arrays;
import java.util.Scanner;

public class _4_ReverseArrOfStrings {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        String[] arr = scan.nextLine().split(",");

        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        String result = String.join(" ", arr);
        System.out.print(result);
    }
}
