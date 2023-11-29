import java.util.Scanner;

public class _12_FibonacciSeq {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int fibCnt = Integer.parseInt(scan.nextLine());

        int n1 = 1;
        int n2 = 1;

        int sum = n1 + n2;

        for (int i = 0; i < fibCnt - 2; i++) {
            sum += n1 + n2;
            n1 = n2;
            n2 = sum;
        }

        System.out.println(sum);
    }
}
