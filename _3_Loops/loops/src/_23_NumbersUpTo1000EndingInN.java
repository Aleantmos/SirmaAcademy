import java.util.Scanner;

public class _23_NumbersUpTo1000EndingInN {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < 100; i++) {
            System.out.println(n);
            n += 10;
        }
    }
}
