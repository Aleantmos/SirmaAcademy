import java.util.Arrays;
import java.util.Scanner;

public class _11_RotateArray {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        String[] arr = scan.nextLine().split(",");

        int n = Integer.parseInt(scan.nextLine());

        int rotations = n % arr.length;

        for (int i = 0; i < rotations; i++) {
            String temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }

        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
