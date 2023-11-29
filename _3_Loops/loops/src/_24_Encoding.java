import java.util.Scanner;

public class _24_Encoding {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        int asciiBase = 33;

        while (n != 0) {
            int curr = n % 10;

            if (curr == 0) {
                System.out.println("ZERO");
            } else {
                char c = (char) (curr + asciiBase);
                while (curr-- > 0) {
                    System.out.print(c);
                }
                System.out.println();
            }
            n = n / 10;
        }
    }
}


