import java.util.Scanner;

public class _4_Number1toNThroughM {
    public static void main(String[] args) {
        Scanner scanner = Util.importScanner();

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i += m) {
            System.out.println(i);
        }
    }
}
