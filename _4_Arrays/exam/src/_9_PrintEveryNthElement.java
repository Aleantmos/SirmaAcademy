import java.util.Arrays;
import java.util.Scanner;

public class _9_PrintEveryNthElement {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        String[] arr = scan.nextLine().split(",");

        int n = Integer.parseInt(scan.nextLine());
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < arr.length; i += n) {
            result.append(arr[i]).append(" ");
        }
        System.out.println(result.toString().trim());


       /* int i = 0;
        int curr = 0;
        StringBuilder result = new StringBuilder();
        while (curr <= arr.length) {
            result.append(String.valueOf(arr[curr]));
            curr = i * n;
            i++;
        }
*/
    }
}
