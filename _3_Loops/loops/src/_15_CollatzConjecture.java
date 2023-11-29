import java.util.Scanner;

public class _15_CollatzConjecture {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int num = Integer.parseInt(scan.nextLine());

        System.out.print(num + " ");

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            System.out.print(num + " ");
        }
    }
}
