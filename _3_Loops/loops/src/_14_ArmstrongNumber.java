import java.util.Scanner;

public class _14_ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int num = Integer.parseInt(scan.nextLine());

        int copy = num;

        int digitsCnt = 0;

        while (copy != 0) {
            digitsCnt++;
            copy /= 10;
        }

        int result = 0;

        copy = num;

        for (int i = 0; i < digitsCnt; i++) {
            int digit = copy % 10;
            int curr = 1;
            int cnt = 0;

            while (cnt < digitsCnt) {
                curr *= digit;
                cnt++;
            }
            result += curr;
            copy /= 10;
        }
        if (num == result) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
