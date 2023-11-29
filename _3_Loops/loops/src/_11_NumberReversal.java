import java.util.Scanner;

public class _11_NumberReversal {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        int copy = n;

        int digitLevel = 1;

        while (copy > 9) {
            digitLevel *= 10;
            copy /= 10;
        }

        int reversed = 0;

        while (n != 0) {
            int digit = n % 10;
            reversed += digit * digitLevel;
            digitLevel /= 10;
            n /= 10;
        }
        System.out.println(reversed);
    }
}
