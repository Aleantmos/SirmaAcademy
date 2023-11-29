import java.util.Scanner;

public class _15_LastKNumbers {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int n = Integer.parseInt(scan.nextLine());
        int k = Integer.parseInt(scan.nextLine());

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n; i++) {

            int curr = 0;
            for (int j = 0; j < k; j++) {
                curr += arr[j + i - k];
            }
            arr[i] = curr;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
